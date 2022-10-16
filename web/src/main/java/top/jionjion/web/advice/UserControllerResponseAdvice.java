package top.jionjion.web.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMappingJacksonResponseBodyAdvice;

import java.util.logging.Logger;

/**
 * @author Jion
 */
@ControllerAdvice()
public class UserControllerResponseAdvice extends AbstractMappingJacksonResponseBodyAdvice {

    final Logger logger = Logger.getLogger(UserControllerRequestAdvice.class.getName());

    /**
     * @param request
     * @param bodyContainer
     * @param contentType   响应类型
     * @param returnType
     * @param request
     * @param response
     */
    @Override
    protected void beforeBodyWriteInternal(MappingJacksonValue bodyContainer, MediaType contentType, MethodParameter returnType, ServerHttpRequest request, ServerHttpResponse response) {
        logger.info("准备输出....");
        logger.info("bodyContainer" + bodyContainer);
        logger.info("contentType" + contentType);
        logger.info("returnType" + returnType);
        logger.info("request" + request);
        logger.info("response" + response);
    }

}
