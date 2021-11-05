package top.jionjion.web.conditional;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * 自定义注解, 在 Web 环境下运行
 *
 *
 * @author Jion
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnWebApplicationCondition.class)
public @interface ConditionalOnWebApplication {

}
