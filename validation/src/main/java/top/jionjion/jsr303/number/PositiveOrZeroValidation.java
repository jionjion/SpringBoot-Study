package top.jionjion.jsr303.number;

import javax.validation.constraints.PositiveOrZero;

/**
 * 数字校验
 *
 * @author jion
 */
public class PositiveOrZeroValidation {

    /**
     * .@PositiveOrZero 正数或者零
     */
    @PositiveOrZero(message = "正数或者零")
    public Object mustPositiveOrZero;
}
