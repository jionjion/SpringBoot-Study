package top.jionjion.jsr303.number;

import javax.validation.constraints.*;

/**
 * 数字校验
 * .@DecimalMin 必须是一个值，并且不能小于指定的值. 可以为字符串数值
 *
 * @author jion
 */
public class DecimalMinValidation {

    /**
     * .@DecimalMin 必须是一个值，并且不能小于指定的值. 可以为字符串数值
     */
    @DecimalMin(value = "0", message = "不能小于0")
    public Object limitDecimalMin;
}
