package top.jionjion.validation.jsr303.number;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 数字校验
 * .@Digits(integer,fraction) 必须是一个数字，其值必须在指定有效位和精度位中
 *
 * @author jion
 */
@SuppressWarnings("unused")
public class DigitsValidation {

    /**
     * .@Digits(integer,fraction) 必须是一个数字，其值必须在指定有效位和精度位中
     */
    @Digits(integer = 2, fraction = 2, message = "BigDecimal最多为两位有效数字, 小数点最多保留两位")
    public BigDecimal bigDecimalDigits;

    @Digits(integer = 2, fraction = 2, message = "BigInteger最多为两位有效数字, 小数点最多保留两位")
    public BigInteger bigIntegerDigits;

    @Digits(integer = 2, fraction = 2, message = "CharSequence最多为两位有效数字, 小数点最多保留两位")
    public CharSequence charSequenceDigits;

    @Digits(integer = 2, fraction = 2, message = "Byte最多为两位有效数字, 小数点最多保留两位")
    public Byte byteDigits;

    @Digits(integer = 2, fraction = 2, message = "Short最多为两位有效数字, 小数点最多保留两位")
    public Short shortDigits;

    @Digits(integer = 2, fraction = 2, message = "Integer最多为两位有效数字, 小数点最多保留两位")
    public Integer intDigits;

    @Digits(integer = 2, fraction = 2, message = "Long最多为两位有效数字, 小数点最多保留两位")
    public Long longDigits;
}
