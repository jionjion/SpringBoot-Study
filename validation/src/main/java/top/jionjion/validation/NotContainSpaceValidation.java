package top.jionjion.validation;

/**
 * 使用自定义注解
 * .@NotContainSpace 自定义注解
 *
 * @author Jion
 */
public class NotContainSpaceValidation {

    @NotContainSpace(message = "不能包含字符串!")
    public String name;
}
