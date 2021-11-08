package top.jionjion.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义验证器.
 * 不能还有空格字符串
 *
 * @author Jion
 */
public class NotContainSpaceValidatorForCharSequence implements ConstraintValidator<NotContainSpace, CharSequence> {
    private static final String SPACE_STRING = " ";

    /**
     * 验证器初始化方法, 在容器加载验证器时执行.
     *
     * @param notContainSpace 注解对象
     */
    @Override
    public void initialize(NotContainSpace notContainSpace) {
        System.out.println("执行初始化方法....");
    }

    /**
     * 验证方法, 不能含有空格字符串
     *
     * @param property 注解标识的属性
     * @param context  验证器上下文对象
     * @return 是否通过验证
     */
    @Override
    public boolean isValid(CharSequence property, ConstraintValidatorContext context) {
        if (property != null && property.toString().trim().contains(SPACE_STRING)) {
            // 注解中, message 属性约定的字符串...
            String messageTemplate = context.getDefaultConstraintMessageTemplate();

            // 禁用默认提示信息, 在注解中, 默认的message的值
            context.disableDefaultConstraintViolation();

            // 设置提示语.
            context.buildConstraintViolationWithTemplate(messageTemplate).addConstraintViolation();
            return false;
        }
        //  返回实例 ConstraintViolationImpl{interpolatedMessage='不能包含字符串!', propertyPath=name,     rootBeanClass=class top.jionjion.validation.NotContainSpaceValidation, messageTemplate='不能包含字符串!'}
        return true;
    }
}