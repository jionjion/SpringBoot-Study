package top.jionjion.core.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import java.util.Collections;
import java.util.EventListener;

/**
 * 向 Web 容器中添加三大组件..
 * 自定义请求处理器, 过滤器, 监听器..
 *
 * @author Jion
 */
@Configuration
public class WebContextConfig {

    /***
     *  注册自定义 servlet
     * @return 自定义 servlet
     */
    @Bean
    public ServletRegistrationBean<? extends Servlet> myHttpServlet() {
        ServletRegistrationBean<MyHttpServlet> registrationBean = new ServletRegistrationBean<>();
        MyHttpServlet myHttpServlet = new MyHttpServlet();
        registrationBean.setServlet(myHttpServlet);
        registrationBean.setName("myHttpServlet");
        registrationBean.addUrlMappings("/my-servlet");
        registrationBean.setLoadOnStartup(100);
        return registrationBean;
    }

    /**
     * 注册自定义 Filter
     * @return 自定义 Filter
     */
    @Bean
    public FilterRegistrationBean<? extends Filter> myHttpFilter() {
        FilterRegistrationBean<MyHttpFilter> registrationBean = new FilterRegistrationBean<>();
        MyHttpFilter myHttpFilter = new MyHttpFilter();
        registrationBean.setFilter(myHttpFilter);
        registrationBean.setUrlPatterns(Collections.singleton("/my-servlet"));
        registrationBean.setOrder(100);
        return registrationBean;
    }

    /**
     * 注册自定义 Listener
     * @return 自定义 Listener
     */
    @Bean
    public ServletListenerRegistrationBean<? extends EventListener> myHttpListen() {
        ServletListenerRegistrationBean<MyServletContextListener> registrationBean = new ServletListenerRegistrationBean<>();
        MyServletContextListener myServletContextListener = new MyServletContextListener();
        registrationBean.setListener(myServletContextListener);
        registrationBean.setOrder(100);
        return registrationBean;
    }

}
