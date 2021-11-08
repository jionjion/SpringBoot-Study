package top.jionjion.validation.jsr303.number;

import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 数字校验
 * .@PositiveOrZero 必须正数或者零
 *
 * @author jion
 */
public class PositiveOrZeroValidation {

    /**
     * .@PositiveOrZero 必须正数或者零
     */
    @PositiveOrZero(message = "BigDecimal必须正数或者零")
    public BigDecimal bigDecimalPositiveOrZero;

    @PositiveOrZero(message = "BigInteger必须正数或者零")
    public BigInteger bigIntegerPositiveOrZero;

    @PositiveOrZero(message = "CharSequence必须正数或者零")
    public CharSequence charSequencePositiveOrZero;

    @PositiveOrZero(message = "Byte必须正数或者零")
    public Byte bytePositiveOrZero;

    @PositiveOrZero(message = "Short必须正数或者零")
    public Short shortPositiveOrZero;

    @PositiveOrZero(message = "Integer必须正数或者零")
    public Integer integerPositiveOrZero;

    @PositiveOrZero(message = "Long必须正数或者零")
    public Long longPositiveOrZero;
}
