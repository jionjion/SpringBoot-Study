package top.jionjion.core.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * 自定义过滤器
 *
 * @author Jion
 */
public class MyHttpFilter extends HttpFilter {

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("Web容器,自定义过滤器初始化..." + filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Web容器,自定义过滤器执行..." + request.getRemoteAddr() + "  " + response.getContentType());
        super.doFilter(request, response, chain);
    }

    @Override
    public void destroy() {
        System.out.println("Web容器,自定义过滤器销毁...");
    }
}
