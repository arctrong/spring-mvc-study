package springmvcstudy2.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        System.out.println(this.getClass().getSimpleName() + " onStartup method called");

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
