package top.jionjion.jsr303.number;

import javax.validation.constraints.Max;

/**
 * 数字校验
 *
 * @author jion
 */
public class MaxValidation {

    /**
     * .@Max(value) 必须是一个数字，并且不能大于指定的值
     */
    @Max(value = 100, message = "不能大于100")
    public Object limitMax;
}
