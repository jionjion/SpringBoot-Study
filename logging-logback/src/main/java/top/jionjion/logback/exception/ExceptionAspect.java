package top.jionjion.logback.exception;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 自定义异常切面
 *
 * @author Jion
 */
@Component
@Aspect
public class ExceptionAspect {

    private final Logger logger = LoggerFactory.getLogger(ExceptionAspect.class);


    @AfterThrowing(pointcut = "within(top.jionjion.logback.service.*)", throwing = "ex")
    public void handleException(JoinPoint joinPoint, Exception ex) throws Exception {
        // 类名
        String clazz = joinPoint.getSignature().getDeclaringType().getCanonicalName();
        // 方法名
        String method = joinPoint.getSignature().getName();

        // 异常判断,自定义异常.日志处理...
        if (ex instanceof SomeException) {
            logger.warn("class: {}, name:{}", clazz, method, ex);
        }

        // 结束抛出,交给下文处理
        throw ex;
    }
}
