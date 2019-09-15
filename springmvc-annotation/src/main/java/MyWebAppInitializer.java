import configs.AppConfig;
import configs.RootConfig;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.AbstractContextLoaderInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;


/**
 * web容器启动的时候创建对象，调用方法来初始化容器以及前端控制器
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    SpringServletContainerInitializer springServletContainerInitializer ;
    WebApplicationInitializer webApplicationInitializer;
        AbstractContextLoaderInitializer contextLoaderInitializer;
        AbstractDispatcherServletInitializer servletInitializer;
        AbstractAnnotationConfigDispatcherServletInitializer annotationConfigDispatcherServletInitializer;

    @Override
    //获取根容器的配置类：相当于Spring的配置文件  =》父容器
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{new RootConfig().getClass()};
    }

    @Override
    //获取web容器的配置类：相当于Spring MVC的配置文件 =》子容器
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{new AppConfig().getClass()};
    }

    @Override
    //获取容DispatcherServlet的映射信息：
    // "/"表示拦截所有请求（包括静态文件，如.js、.png，但不包括*.jsp）
    // "/*"表示拦截所有请求（包括静态文件，如.js、.png，且包括*.jsp）jsp页面是tomcat的jsp引擎解析的
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

