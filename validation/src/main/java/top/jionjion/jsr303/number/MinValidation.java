package top.jionjion.jsr303.number;

import javax.validation.constraints.Min;

/**
 * 数字校验
 * .@Min(value) 必须是数字，并且不能小于指定的值
 *
 * @author jion
 */
public class MinValidation {

    /**
     * .@Min(value) 必须是数字，并且不能小于指定的值
     */
    @Min(value = 0, message = "不能小于0")
    public Object limitMin;
}
