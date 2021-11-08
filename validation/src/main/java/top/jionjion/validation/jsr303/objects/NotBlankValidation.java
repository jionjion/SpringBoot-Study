package top.jionjion.validation.jsr303.objects;

import javax.validation.constraints.NotBlank;

/**
 * 通用对象校验
 * .@NotBlank 不能为空串
 *
 * @author jion
 */
public class NotBlankValidation {

    /**
     * .@NotBlank 不能为空串
     */
    @NotBlank(message = "不能为空串")
    public String mustNotBlank;
}
