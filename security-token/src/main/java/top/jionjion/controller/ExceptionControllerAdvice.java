package top.jionjion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常处理通知
 *
 * @author Jion
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(BadCredentialsException.class)
    public void badCredentialsException(BadCredentialsException e) {
        //用户名或密码错误
        logger.error(e.getMessage());
    }
}