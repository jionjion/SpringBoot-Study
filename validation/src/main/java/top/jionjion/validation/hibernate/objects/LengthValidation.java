package top.jionjion.validation.hibernate.objects;

import org.hibernate.validator.constraints.Length;

/**
 * 通用对象校验
 * .@Length 指定字符串的长度在范围内
 *
 * @author jion
 */
public class LengthValidation {

    /**
     * .@Length 指定字符串的长度在范围内
     */
    @Length(min = 1, max = 10,message = "必须字符串长度在[0,10]之间")
    public String mustLength;
}
