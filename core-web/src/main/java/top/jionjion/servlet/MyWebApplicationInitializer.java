package top.jionjion.servlet;

import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;

/**
 * 上古版本, 在外置 tomcat 启动时, 为 Web容器添加什么....比如过滤器,拦截器什么.
 * servlet3.0规范中,约定,在 META-INF/services 目录下文件 javax.servlet.ServletContainerInitializer 中写入其同名接口具体实现.
 * 以便在Web容器启动时,通过java配置容器对象,实现注入组件.
 * Spring 中默认使用 org.springframework.web.SpringServletContainerInitializer 类来约定容器启动时的加载动作.
 * 在改实现类中, 具体是通过调用 WebApplicationInitializer 接口的具体实现类完成调用.
 *
 * 不过现在都是使用内置Tomcat, 则调用
 * org.springframework.boot.web.embedded.tomcat.TomcatStarter#onStartup具体实现.
 * 从而注入 ServletContextInitializer 接口的具体实现类
 *
 * @author Jion
 */
@Deprecated
@Component
public class MyWebApplicationInitializer implements WebApplicationInitializer {

    /**
     * 为 Web容器添加什么..
     *
     * @param servletContext Web 容器
     */
    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println("不依赖世面上的Web容器,自行创建..." + servletContext);
    }
}
