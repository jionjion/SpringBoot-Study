package top.jionjion.controller;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Jion
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(BadCredentialsException.class)
    public void badCredentialsException(BadCredentialsException e) {
        //用户名或密码错误
        System.out.println(e.getMessage());
        // throw new  BadCredentialsException(e.getMessage());
    }
}