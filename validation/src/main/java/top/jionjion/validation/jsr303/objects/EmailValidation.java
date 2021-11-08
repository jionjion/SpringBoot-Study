package top.jionjion.validation.jsr303.objects;

import javax.validation.constraints.Email;

/**
 * 通用对象校验
 * .@Email 必须为邮箱
 *
 * @author jion
 */
public class EmailValidation {

    /**
     * .@Email 必须为邮箱
     */
    @Email(message = "必须为邮箱格式")
    public String mustEmail;
}
