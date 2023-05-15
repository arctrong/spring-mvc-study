package jettylivewar.starter;

import org.apache.tomcat.util.scan.StandardJarScanner;
import org.eclipse.jetty.apache.jsp.JettyJasperInitializer;
import org.eclipse.jetty.jsp.JettyJspServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.component.AbstractLifeCycle;

import java.io.File;
import java.io.IOException;

import static org.eclipse.jetty.servlet.ServletContextHandler.ServletContainerInitializerCaller;
import static org.eclipse.jetty.webapp.WebInfConfiguration.CONTAINER_JAR_PATTERN;

public class JspSupportEnablingHelper {

    private JspSupportEnablingHelper() {
    }

    /**
     * Setup JSP Support for ServletContextHandlers.
     * <p>NOTE: This is not required or appropriate if using a WebAppContext.</p>
     *
     * @param servletContextHandler the ServletContextHandler to configure
     * @throws IOException if unable to configure
     */
    public static void enableEmbeddedJspSupport(ServletContextHandler servletContextHandler)
            throws IOException {

        // Set the ContainerIncludeJarPattern so that jetty examines these
        // container-path jars for TLDs, web-fragments etc.
        // If you omit the JAR that contains the JSTL .tlds, the JSP engine will
        // scan for them instead.
        servletContextHandler.setAttribute(CONTAINER_JAR_PATTERN,
                ".*/[^/]*servlet-api-[^/]*\\.jar$|.*/javax.servlet.jsp.jstl-.*\\.jar$|" +
                        ".*/[^/]*taglibs.*\\.jar$");

        // Establish Scratch directory for the servlet context (used by JSP compilation)
        File tempDir = new File(System.getProperty("java.io.tmpdir"));
        File scratchDir = new File(tempDir.toString(), "embedded-jetty-jsp");

        if (!scratchDir.exists()) {
            if (!scratchDir.mkdirs()) {
                throw new IOException("Unable to create scratch directory: " + scratchDir);
            }
        }
        servletContextHandler.setAttribute("javax.servlet.context.tempdir", scratchDir);

        // Set Classloader of Context to be sane (needed for JSTL) JSP requires a non-System
        // classloader, this simply wraps the embedded System classloader in a way that makes
        // it suitable for JSP to use.
        // It turned out that in this domo project this class loader substitution should not
        // be done.
//        ClassLoader jspClassLoader = new URLClassLoader(new URL[0],
//                JspSupportEnablingHelper.class.getClassLoader());
//        servletContextHandler.setClassLoader(jspClassLoader);

        // Manually call JettyJasperInitializer on context startup
        servletContextHandler.addBean(new JspStarter(servletContextHandler));

        // Create/register JSP Servlet (must be named to "jsp" per spec)
        ServletHolder holderJsp = new ServletHolder("jsp", JettyJspServlet.class);
        holderJsp.setInitOrder(0);
        holderJsp.setInitParameter("logVerbosityLevel", "DEBUG");
        holderJsp.setInitParameter("fork", "false");
        holderJsp.setInitParameter("xpoweredBy", "false");
        holderJsp.setInitParameter("compilerTargetVM", "1.8");
        holderJsp.setInitParameter("compilerSourceVM", "1.8");
        holderJsp.setInitParameter("keepgenerated", "true");
        servletContextHandler.addServlet(holderJsp, "*.jsp");
    }

    /**
     * JspStarter for embedded ServletContextHandlers
     * <p />
     * This is added as a bean that is a jetty LifeCycle on the ServletContextHandler.
     * This bean's doStart method will be called as the ServletContextHandler starts,
     * and will call the ServletContainerInitializer for the jsp engine.
     */
    private static class JspStarter extends AbstractLifeCycle
            implements ServletContainerInitializerCaller {
        JettyJasperInitializer sci;
        ServletContextHandler context;

        public JspStarter(ServletContextHandler context) {
            this.sci = new JettyJasperInitializer();
            this.context = context;
            this.context.setAttribute("org.apache.tomcat.JarScanner", new StandardJarScanner());
        }

        @Override
        protected void doStart() throws Exception {
            ClassLoader old = Thread.currentThread().getContextClassLoader();
            Thread.currentThread().setContextClassLoader(context.getClassLoader());
            try {
                sci.onStartup(null, context.getServletContext());
                super.doStart();
            } finally {
                Thread.currentThread().setContextClassLoader(old);
            }
        }
    }
}
