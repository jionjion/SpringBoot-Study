package top.jionjion.jsr303.number;

import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NegativeOrZero;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 数字校验
 * .@NegativeOrZero 必须为负数或者零
 *
 * @author jion
 */
public class NegativeOrZeroValidation {

    /**
     * .@NegativeOrZero 必须为负数或者零
     */
    @NegativeOrZero(message = "BigDecimal必须为负数或者零")
    public BigDecimal bigDecimalNegativeOrZero;

    @NegativeOrZero(message = "BigInteger必须为负数或者零")
    public BigInteger bigIntegerNegativeOrZero;

    @NegativeOrZero(message = "CharSequence必须为负数或者零")
    public CharSequence charSequenceNegativeOrZero;

    @NegativeOrZero(message = "Byte必须为负数或者零")
    public Byte byteNegativeOrZero;

    @NegativeOrZero(message = "Short必须为负数或者零")
    public Short shortNegativeOrZero;

    @NegativeOrZero(message = "Integer必须为负数或者零")
    public Integer integerNegativeOrZero;

    @NegativeOrZero(message = "Long必须为负数或者零")
    public Long longNegativeOrZero;
}
