package top.jionjion.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 在 Web 环境下使用
 *
 * @author Jion
 */
public class OnWebApplicationCondition implements Condition {


    /**
     * 自定义匹配规则
     *
     * @param context  Spring提供的上下文信息, 包含Spring中的核心类及上下文信息
     * @param metadata Spring提供的注解信息, 包裹注解属性.. 等
     * @return 是否生效
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        System.out.println(getClass() + " 注解信息" + metadata);
        System.out.println(getClass() + "上下文信息" + context);
        return true;
    }
}
