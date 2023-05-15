package jettywarless;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;

import java.net.URL;
import java.util.Arrays;

public class Main {

    private static final boolean DEBUG = Boolean.getBoolean("debug");

    public static void main(final String[] args) throws Exception {

        System.out.println("Starting class " + Main.class.getName());

        waitForDebuggerConnection();

        Server server = new Server(8080);

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/");

        URL resourceBaseUrl = Main.class.getProtectionDomain().getCodeSource().getLocation();
        String appClasspath = resourceBaseUrl.toExternalForm();
        webAppContext.setResourceBase(appClasspath +
                (appClasspath.endsWith(".jar") ? "!/" : "") +
                "webapp/");

        // The following is required for detecting the `WebApplicationInitializer` implementation
        Configuration.ClassList classlist = Configuration.ClassList.setServerDefault(server);
        classlist.addBefore(
                "org.eclipse.jetty.webapp.JettyWebXmlConfiguration",
                "org.eclipse.jetty.annotations.AnnotationConfiguration");
        webAppContext.setExtraClasspath(appClasspath);

//        webAppContext.setParentLoaderPriority(true);

//        webAppContext.setAttribute(CONTAINER_JAR_PATTERN,
//                ".*/[^/]*servlet-api-[^/]*\\.jar$|.*/javax.servlet.jsp.jstl-.*\\.jar$|" +
//                        ".*/[^/]*taglibs.*\\.jar$");

        if (DEBUG) {
            server.setDumpAfterStart(true);
            System.out.println("----- Context configuration -----");
            System.out.println(Arrays.toString(webAppContext.getConfigurations()));
        }

        server.setHandler(webAppContext);

        server.start();
        server.join();
    }

    private static void waitForDebuggerConnection() {
        if (DEBUG) {
            System.out.println("Connect a debugger and press Enter key to continue...");
            try {
                int ignore = System.in.read();
            } catch (Exception ignored) {
            }
        }
    }
}
