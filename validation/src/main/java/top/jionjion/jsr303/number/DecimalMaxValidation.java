package top.jionjion.jsr303.number;

import javax.validation.constraints.DecimalMax;

/**
 * 数字校验
 * .@DecimalMax 必须是一个值，并且不能大于指定的值. 可以为字符串数值
 *
 * @author jion
 */
public class DecimalMaxValidation {

    /**
     * .@DecimalMax 必须是一个值，并且不能大于指定的值. 可以为字符串数值
     */
    @DecimalMax(value = "100", message = "不能大于100")
    public Object limitDecimalMax;
}
