package web.config.servlet;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// Similar to the web.xml configuration (front controller)
public class SpringMVCDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {ServletDispatcherXml.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
