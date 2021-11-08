package top.jionjion.validation.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 自定义注解,配置条件.
 * 不能还有空格字符串
 *
 * @author Jion
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotContainSpaceValidatorForCharSequence.class)
public @interface NotContainSpace {
    // 默认错误消息, 消息 key
    String message() default "top.jionjion.validation.NotContainSpace.message";

    // 分组
    Class<?>[] groups() default {};

    // 负载
    Class<? extends Payload>[] payload() default {};

    // 指定多个时使用，从而支持重复注解
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        NotContainSpace[] value();
    }
}