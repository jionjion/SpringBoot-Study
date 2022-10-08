package top.jionjion.validation.jsr303.number;

import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 数字校验
 * .@DecimalMin 必须是一个值，并且不能小于指定的值. 不支持浮点字符，可以为字符串数值
 *
 * @author jion
 */
@SuppressWarnings("unused")
public class DecimalMinValidation {

    /**
     * .@DecimalMin 必须是一个值，并且不能小于指定的值. 不支持浮点字符，可以为字符串数值
     */
    @DecimalMin(value = "1", message = "BigDecimal不能小于1")
    public BigDecimal bigDecimalLimitDecimalMin;

    @DecimalMin(value = "1", message = "BigInteger不能小于1")
    public BigInteger bigIntegerLimitDecimalMin;

    @DecimalMin(value = "1", message = "CharSequence不能小于1")
    public CharSequence charSequenceLimitDecimalMin;

    @DecimalMin(value = "1", message = "Byte不能小于1")
    public Byte byteLimitDecimalMin;

    @DecimalMin(value = "1", message = "Short不能小于1")
    public Short shortLimitDecimalMin;

    @DecimalMin(value = "1", message = "Integer不能小于1")
    public Integer integerLimitDecimalMin;

    @DecimalMin(value = "1", message = "Long不能小于1")
    public Long longLimitDecimalMin;
}
