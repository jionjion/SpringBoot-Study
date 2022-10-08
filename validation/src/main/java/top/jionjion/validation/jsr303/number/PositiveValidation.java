package top.jionjion.validation.jsr303.number;

import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 数字校验
 * .@Positive 必须为正数
 *
 * @author jion
 */
@SuppressWarnings("unused")
public class PositiveValidation {

    /**
     * .@Positive 必须为正数
     */
    @Positive(message = "必须为正数")
    public BigDecimal bigDecimalPositive;

    @Positive(message = "必须为正数")
    public BigInteger bigIntegerPositive;

    @Positive(message = "必须为正数")
    public CharSequence charSequencePositive;

    @Positive(message = "必须为正数")
    public Byte bytePositive;

    @Positive(message = "必须为正数")
    public Short shortPositive;

    @Positive(message = "必须为正数")
    public Integer integerPositive;

    @Positive(message = "必须为正数")
    public Long longPositive;
}
