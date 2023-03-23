package springmvcstudy2.config;

/**
 * This class was used for demonstration and is not activated now.
 */
//@Order(2)
public class MyQuickApplicationInitializer
//        extends AbstractAnnotationConfigDispatcherServletInitializer
{

//    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

//    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println(this.getClass().getSimpleName() + " getServletConfigClasses method called");
        return new Class<?>[]{MyApplicationConfig.class};
    }

//    @Override
    protected String[] getServletMappings() {
        System.out.println(this.getClass().getSimpleName() + " getServletMappings method called");
        return new String[]{"/ui/*", "/ui1/*"};
    }
}
