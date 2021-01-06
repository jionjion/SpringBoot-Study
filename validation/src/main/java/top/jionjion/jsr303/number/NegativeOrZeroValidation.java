package top.jionjion.jsr303.number;

import javax.validation.constraints.NegativeOrZero;

/**
 * 数字校验
 *
 * @author jion
 */
public class NegativeOrZeroValidation {

    /**
     * .@NegativeOrZero 必须为负数或者零
     */
    @NegativeOrZero(message = "必须为负数或者零")
    public Object mustNegativeOrZero;
}
