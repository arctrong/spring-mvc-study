package jettylivewar.bootstrap;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;

public class JettyBootstrap {

    public static void main(String[] args) {
        try {
            URL warLocation = JettyBootstrap.class.getProtectionDomain().getCodeSource().getLocation();
            if (warLocation == null) {
                throw new IOException("JettyBootstrap not discoverable");
            }

            LiveWarClassLoader warClassLoader =
                    new LiveWarClassLoader(warLocation, "WEB-INF/jetty-server/");
            System.out.println("Using ClassLoader: " + warClassLoader);
            Thread.currentThread().setContextClassLoader(warClassLoader);

            File warFile = new File(warLocation.toURI());
            System.setProperty("jettylivewar.LOCATION", warFile.toPath().toRealPath().toString());

            Class<?> mainClass = Class.forName("jettylivewar.starter.ServerMain", false, warClassLoader);
            Method mainMethod = mainClass.getMethod("main", args.getClass());
            mainMethod.invoke(mainClass, new Object[]{args});
        } catch (Throwable t) {
            t.printStackTrace(System.err);
            System.exit(-1);
        }
    }
}
