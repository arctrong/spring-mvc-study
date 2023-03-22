package springmvcstudy2.config;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//@Order(2)
public class MyQuickApplicationInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println(this.getClass().getSimpleName() + " getServletConfigClasses method called");
        return new Class<?>[]{MyApplicationConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println(this.getClass().getSimpleName() + " getServletMappings method called");
        return new String[]{"/ui/*", "/ui1/*"};
    }
}
