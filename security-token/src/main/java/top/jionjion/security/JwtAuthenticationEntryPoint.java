package top.jionjion.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Token 验证,失败时进入
 *
 * @author Jion
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException exception) throws IOException {

        logger.error("用户访问资源没有携带正确的token, {}", exception.getMessage());
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, exception.getMessage());
    }
}
