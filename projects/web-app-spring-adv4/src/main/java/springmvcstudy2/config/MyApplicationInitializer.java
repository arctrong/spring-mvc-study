package springmvcstudy2.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.logging.Logger;

public class MyApplicationInitializer implements WebApplicationInitializer {

    private static final Logger logger =
            Logger.getLogger(MyApplicationInitializer.class.getName());

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        logger.info(this.getClass().getSimpleName() + " onStartup method called");

        if (System.getProperty("debug") != null) {
            System.out.println("Connect a debugger and press Enter key to continue...");
            try {
                System.in.read();
            } catch (Exception ignored) {
            }
        }

        AnnotationConfigWebApplicationContext webApplicationContext =
                new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(MyApplicationConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);

        ServletRegistration.Dynamic registration =
                servletContext.addServlet("front-controller", dispatcherServlet);

        registration.setLoadOnStartup(1);
        registration.addMapping("/ui/*");
    }
}
