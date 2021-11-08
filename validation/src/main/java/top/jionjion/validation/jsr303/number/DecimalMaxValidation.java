package top.jionjion.validation.jsr303.number;

import javax.validation.constraints.DecimalMax;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 数字校验
 * .@DecimalMax 必须是一个数字，并且不能大于指定的值. 不支持浮点字符，可以为字符串数值
 *
 * @author jion
 */
public class DecimalMaxValidation {

    /**
     * .@DecimalMax 必须是一个值，并且不能大于指定的值. 不支持浮点字符，可以为字符串数值
     */
    @DecimalMax(value = "1", message = "BigDecimal不能大于1")
    public BigDecimal bigDecimalLimitDecimalMax;

    @DecimalMax(value = "1", message = "BigInteger不能大于1")
    public BigInteger bigIntegerLimitDecimalMax;

    @DecimalMax(value = "1", message = "CharSequence不能大于1")
    public CharSequence charSequenceLimitDecimalMax;

    @DecimalMax(value = "1", message = "Byte不能大于1")
    public Byte byteLimitDecimalMax;

    @DecimalMax(value = "1", message = "Short不能大于1")
    public Short shortLimitDecimalMax;

    @DecimalMax(value = "1", message = "Integer不能大于1")
    public Integer integerLimitDecimalMax;

    @DecimalMax(value = "1", message = "Long不能大于1")
    public Long longLimitDecimalMax;
}
