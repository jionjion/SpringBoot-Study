package top.jionjion.jsr303.number;

import javax.validation.constraints.*;

/**
 * 数字校验
 *
 * @author jion
 */
public class DigitsValidation {

    /**
     * .@Digits(integer,fraction) 必须是一个数字，其值必须在指定有效位中
     */
    @Digits(integer = 4, fraction = 2, message = "必须为四位有效数字, 小数点保留两位")
    public Object mustInDigits;
}
