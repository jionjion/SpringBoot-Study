package top.jionjion.web.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.logging.Logger;

/**
 * @author Jion
 */
@ControllerAdvice()
public class UserControllerResponseAdvice implements ResponseBodyAdvice<Object> {

    final Logger logger = Logger.getLogger(UserControllerResponseAdvice.class.getName());

    /**
     * 是否执行响应拦截
     *
     * @param returnType    返回Java类的类型
     * @param converterType 响应内容Http消息转换器类类型
     * @return 是否执行拦截
     */
    @Override
    public boolean supports(@NonNull MethodParameter returnType, @NonNull Class<? extends HttpMessageConverter<?>> converterType) {
        logger.info(() -> "准备判断是否执行响应拦截");
        logger.info("返回类型 " + returnType.getParameterType());

        return true;
    }

    /**
     * @param body                  响应内容, 一般是业务类
     * @param returnType            Controller 中的方法返回类型
     * @param selectedContentType   响应 ContentType 类型
     * @param selectedConverterType 响应内容 Http消息转换器类类型
     * @param request               当前请求
     * @param response              当前响应
     * @return 响应输出对象
     */
    @Override
    public Object beforeBodyWrite(Object body, @NonNull MethodParameter returnType, @NonNull MediaType selectedContentType, @NonNull Class<? extends HttpMessageConverter<?>> selectedConverterType, @NonNull ServerHttpRequest request, @NonNull ServerHttpResponse response) {

        logger.info(() -> "响应转换前, 当前要转换的类" + body.getClass().getName());
        logger.info(() -> "响应转换前, 方法定义的返回类型" + returnType.getParameterType());
        logger.info(() -> "响应转换前, 使用的响应转换器为: " + selectedConverterType.getName());
        logger.info(() -> "响应转换前, 当前请求" + request);
        logger.info(() -> "响应转换前, 当前响应" + response);
        return body;
    }
}
