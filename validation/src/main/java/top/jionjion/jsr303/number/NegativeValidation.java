package top.jionjion.jsr303.number;

import javax.validation.constraints.Negative;

/**
 * 数字校验
 * .@Negative 必须为负数
 *
 * @author jion
 */
public class NegativeValidation {

    /**
     * .@Negative 必须为负数
     */
    @Negative(message = "必须为负数")
    public Object mustNegative;
}
