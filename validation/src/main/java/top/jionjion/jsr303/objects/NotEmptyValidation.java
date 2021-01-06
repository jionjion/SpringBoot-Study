package top.jionjion.jsr303.objects;

import javax.validation.constraints.NotEmpty;

/**
 * 通用对象校验
 *
 * @author jion
 */
public class NotEmptyValidation {

    /**
     * .@NotEmpty 集合, 数组, 字符不能为空
     */
    @NotEmpty(message = "集合, 数组, 字符不能为空")
    public Object mustNotEmpty;
}
