package top.jionjion.core.servlet;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;

/**
 * 上古版本, 在外置 tomcat 启动时, 为 Web容器添加什么....比如过滤器,拦截器什么.
 * servlet3.0规范中,约定,在 META-INF/services 目录下文件 javax.servlet.ServletContainerInitializer 中写入其同名接口具体实现.
 * 以便在Web容器启动时,通过java配置容器对象,实现注入组件.
 * Spring 中默认使用 org.springframework.web.SpringServletContainerInitializer 类来约定容器启动时的加载动作.
 * 在实现类中, 具体是通过调用 WebApplicationInitializer 接口的具体实现类完成调用.
 *
 * 不过现在都是使用内置Tomcat, 则调用
 * org.springframework.boot.web.embedded.tomcat.TomcatStarter#onStartup具体实现.
 * 从而注入 ServletContextInitializer 接口的具体实现类
 *
 *
 * 实现 ServletContextInitializer 接口, 在容器启动执行相关方法. 常用于注册Web中的 servlet, filter, listener 等
 *
 *  Spring提供相关子类有
 *  DispatcherServletRegistrationBean 注册一个新的DispatcherServlet,处理请求
 *  ServletRegistrationBean 注册新的Servlet请求处理器,对某个请求进行响应.
 *  FilterRegistrationBean  注册新的Filter请求过滤器,对请求进行过滤
 *  DelegatingFilterProxyRegistrationBean 注册新的Filter请求过滤器的代理对象
 *  ServletListenerRegistrationBean 注册新的Listener监听器,对容器进行监听
 *
 * @author Jion
 */
@Component
public class MyServletContextInitializer implements ServletContextInitializer {

    /**
     * 为 Web容器添加什么..
     *
     * @param servletContext Web 容器
     */
    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println("Web容器,启动内置Tomcat启动....." + servletContext);
    }
}
