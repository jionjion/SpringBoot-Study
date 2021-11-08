package top.jionjion.validation.jsr303.number;

import javax.validation.constraints.Negative;
import java.math.BigDecimal;
import java.math.BigInteger;

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
    @Negative(message = "BigDecimal必须为负数")
    public BigDecimal bigDecimalNegative;

    @Negative(message = "BigInteger必须为负数")
    public BigInteger bigIntegerNegative;

    @Negative(message = "CharSequence必须为负数")
    public CharSequence charSequenceNegative;

    @Negative(message = "Byte必须为负数")
    public Byte byteNegative;

    @Negative(message = "Short必须为负数")
    public Short shortNegative;

    @Negative(message = "Integer必须为负数")
    public Integer integerNegative;

    @Negative(message = "Long必须为负数")
    public Long longNegative;
}
