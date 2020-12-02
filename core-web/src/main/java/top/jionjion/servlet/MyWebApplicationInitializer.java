package top.jionjion.servlet;

import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;

/**
 *  虽然实现了 WebApplicationInitializer, 但是不会被调用.
 *  仍然以Tomcat的为主
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
