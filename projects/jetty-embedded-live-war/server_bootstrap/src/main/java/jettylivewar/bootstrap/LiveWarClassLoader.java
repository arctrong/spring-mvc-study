package jettylivewar.bootstrap;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

public class LiveWarClassLoader extends ClassLoader implements Closeable {
    private static final String ID = LiveWarClassLoader.class.getSimpleName();
    private static final boolean DEBUG = Boolean.getBoolean("debug");
    private final String classesBase;
    private final URI warFileUri;
    private final JarFile warFile;

    public LiveWarClassLoader(URL warFileUrl, String classesBase)
            throws URISyntaxException, IOException {
        this.warFileUri = warFileUrl.toURI();
        this.warFile = new JarFile(new File(this.warFileUri));
        this.classesBase = classesBase;
    }

    public void close() throws IOException {
        warFile.close();
    }

    private void debug(String format, Object... args) {
        if (DEBUG) {
            System.err.printf('[' + ID + "] " + format + "%n", args);
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        debug("findClass: %s", name);
        String path = name.replace('.', '/').concat(".class");
        ZipEntry entry = findEntry(path);
        if (entry != null) {
            try {
                return loadClass(name, entry);
            } catch (IOException e) {
                throw new ClassNotFoundException(name, e);
            }
        } else {
            throw new ClassNotFoundException(name);
        }
    }

    private ZipEntry findEntry(String name) {
        StringBuilder path = new StringBuilder();
        path.append(classesBase);
        if (name.charAt(0) == '/') {
            path.append(name.substring(1));
        } else {
            path.append(name);
        }
        ZipEntry entry = warFile.getEntry(path.toString());
        debug("findEntry(%s) %s => %s", name, path, entry);
        return entry;
    }

    @Override
    protected URL findResource(String name) {
        debug("findResource: %s", name);
        ZipEntry entry = findEntry(name);
        if (entry != null) {
            try {
                return URI.create("jar:" + this.warFileUri.toASCIIString() + "!/" + entry.getName()).toURL();
            } catch (MalformedURLException e) {
                e.printStackTrace(System.err);
                return null;
            }
        }
        return null;
    }

    @Override
    protected Enumeration<URL> findResources(String name) throws IOException {
        debug("findResources: %s", name);
        List<URL> urls = new ArrayList<>();
        URL self = findResource(name);
        if (self != null) {
            urls.add(self);
        }

        if (getParent() != null) {
            Enumeration<URL> parent = getParent().getResources(name);
            while (parent.hasMoreElements()) {
                urls.add(parent.nextElement());
            }
        }

        return Collections.enumeration(urls);
    }

    private Class<?> loadClass(String name, ZipEntry entry) throws IOException {
        try (InputStream in = warFile.getInputStream(entry);
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            int len;
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            while (true) {
                len = in.read(buffer, 0, bufferSize);
                if (len < 0) {
                    break;
                }
                out.write(buffer, 0, len);
            }
            byte[] classBytes = out.toByteArray();
            Class<?> aClass = defineClass(name, classBytes, 0, classBytes.length);

            int lastDot = name.lastIndexOf('.');
            if (lastDot > -1) {
                String packageName = name.substring(0, lastDot);
                if (getPackage(packageName) == null) {
                    definePackage(packageName, null, null, null, null, null, null, null);
                }
            }
            return aClass;
        }
    }

    @Override
    public String toString() {
        return String.format("%s[%s]", this.getClass().getName(), this.warFileUri);
    }

    @Override
    protected Package getPackage(String name) {
        return super.getPackage(name);
    }
}
