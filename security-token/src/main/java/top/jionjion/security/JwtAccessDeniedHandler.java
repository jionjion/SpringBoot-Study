package top.jionjion.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 当用户在没有授权的时候，返回的指定信息
 *
 * @author Jion
 */
@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException exception) throws IOException {

        logger.error("用户访问没有授权资源, {}", exception.getMessage());

        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, exception.getMessage());
    }
}
