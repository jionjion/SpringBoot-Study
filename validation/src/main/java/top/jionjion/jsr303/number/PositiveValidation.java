package top.jionjion.jsr303.number;

import javax.validation.constraints.Positive;

/**
 * 数字校验
 * .@Positive 必须为正数
 *
 * @author jion
 */
public class PositiveValidation {

    /**
     * .@Positive 必须为正数
     */
    @Positive(message = "必须为正数")
    public Object mustPositive;

}
