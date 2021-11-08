package top.jionjion.core.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义Servlet请求, 通过 ServletRegistrationBean 注册
 * http://127.0.0.1:8080/my-servlet
 *
 * @author Jion
 */
public class MyHttpServlet extends HttpServlet {

    /**
     * @param request  请求
     * @param response 响应
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Web容器,处理请求...." + request.getRequestURI() + "  " + response.getStatus());
        response.getWriter().print("hello");
    }
}
