package top.jionjion.jsr303.objects;

import javax.validation.constraints.Pattern;

/**
 * 通用对象校验
 * .@Pattern(regex=,flag=) 必须符合正则表达式
 *
 * @author jion
 */
public class PatternValidation {

    /**
     * .@Pattern(regex=,flag=) 必须符合正则表达式
     */
    @Pattern(regexp = "^[0-9]*$", message = "正则匹配必须为数字")
    public String mustPattern;
}
