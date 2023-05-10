package jettylivewar.starter;

import org.eclipse.jetty.security.ConstraintMapping;
import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.PathResource;
import org.eclipse.jetty.util.security.Constraint;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;

import static jettylivewar.starter.ServerMain.OperationalMode.IDE;
import static jettylivewar.starter.ServerMain.OperationalMode.WAR;

public class ServerMain {

    enum OperationalMode {
        IDE,
        WAR
    }

    private static final boolean DEBUG = Boolean.getBoolean("debug");
    private Path basePath;
    private OperationalMode operationalMode;

    public static void main(String[] args) {

        waitForDebuggerConnection();

        if (DEBUG) {
            System.out.println("System properties:");
            for (Map.Entry<Object, Object> entry : System.getProperties().entrySet()) {
                System.out.println("    " + entry.getKey() + "=" + entry.getValue());
            }
        }

        try {
            new ServerMain().run();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private void run() throws Throwable {

        Server server = new Server(8080);

        WebAppContext context = new WebAppContext();
        context.setContextPath("/");

        // The following method works, but it cannot be used here because the final built artifact
        // may be used as a WAR file. So XML-based configuration must be used.
        // The method is preserved in the code just for information purpose.
        // applyRestrictions(context);

        defineOperationalMode();
        System.out.println("operationalMode=" + operationalMode);
        System.out.println("basePath=" + basePath);

        switch (operationalMode) {
            case WAR:
                context.setWar(basePath.toString());
                break;
            case IDE:
                context.setBaseResource(new PathResource(basePath.resolve("src/main/webapp")));
                // Add my-webapp compiled classes & resources (copied into place from src/main/resources)
                context.setExtraClasspath(getExtraClasspath());
                break;
        }

        // This webapp will use JSP and JSTL. We need to enable the AnnotationConfiguration
        // in order to correctly set up the JSP container.
        // This is also required for finding the Spring MVC SpringServletContainerInitializer.
        Configuration.ClassList classlist = Configuration.ClassList
                .setServerDefault(server);
        classlist.addBefore(
                "org.eclipse.jetty.webapp.JettyWebXmlConfiguration",
                "org.eclipse.jetty.annotations.AnnotationConfiguration");

        JspSupportEnablingHelper.enableEmbeddedJspSupport(context);

        server.setHandler(context);

        if (DEBUG) {
            server.setDumpAfterStart(true);
            System.out.println("----- Context configuration -----");
            System.out.println(Arrays.toString(context.getConfigurations()));
        }

        server.start();
        server.join();
    }

    private String getExtraClasspath() throws URISyntaxException {
        Path thisLocation = Paths.get(ServerMain.class.getProtectionDomain()
                .getCodeSource().getLocation().toURI());
        Path webappLocation = thisLocation.resolve("../../my-webapp/my-webapp/WEB-INF/")
                .normalize().toAbsolutePath();
        Path libPath = webappLocation.resolve("lib");
        String libs = webappLocation.resolve("classes").toUri().toString();
        if (Files.exists(libPath)) {
            libs += ";" + libPath.toUri() + "*";
        }
        return libs;
    }

    private void defineOperationalMode() throws IOException {
        // Property set by jetty.bootstrap.JettyBootstrap
        String warLocation = System.getProperty("jettylivewar.LOCATION");
        if (warLocation != null) {
            Path warPath = new File(warLocation).toPath().toRealPath();
            if (Files.exists(warPath) && Files.isRegularFile(warPath)) {
                this.basePath = warPath;
                this.operationalMode = WAR;
                return;
            }
        }
        // We are in development mode, likely building and testing from an IDE.
        Path devPath = new File("my-webapp").toPath().toRealPath();
        if (Files.exists(devPath) && Files.isDirectory(devPath)) {
            this.basePath = devPath;
            this.operationalMode = IDE;
            return;
        }
        throw new FileNotFoundException("Unable to configure: WebAppContext base resource undefined");
    }

    private static void waitForDebuggerConnection() {
        if (System.getProperty("debug") != null) {
            System.out.println("Connect a debugger and press Enter key to continue...");
            try {
                int ignore = System.in.read();
            } catch (Exception ignored) {
            }
        }
    }

    /**
     * Makes adjustments that must be equivalent to the file `WEB-INF/web.xml`.
     */
    private static void applyRestrictions(WebAppContext context) {

        context.setInitParameter("org.eclipse.jetty.servlet.Default.dirAllowed", "false");

        ConstraintSecurityHandler securityHandler = new ConstraintSecurityHandler();
        context.setSecurityHandler(securityHandler);

        Constraint constraint = new Constraint("forbidden for all", Constraint.NONE);
        constraint.setAuthenticate(true);

        ConstraintMapping constraintMapping = new ConstraintMapping();
        constraintMapping.setPathSpec("/jettylivewar/*");
        constraintMapping.setConstraint(constraint);
        securityHandler.addConstraintMapping(constraintMapping);

        constraintMapping = new ConstraintMapping();
        constraintMapping.setPathSpec("/META-INF/*");
        constraintMapping.setConstraint(constraint);
        securityHandler.addConstraintMapping(constraintMapping);

        constraintMapping = new ConstraintMapping();
        constraintMapping.setPathSpec("/WEB-INF/*");
        constraintMapping.setConstraint(constraint);
        securityHandler.addConstraintMapping(constraintMapping);
    }
}
