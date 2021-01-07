package top.jionjion.jsr303.number;

import javax.validation.constraints.Max;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 数字校验
 * .@Max(value) 必须是一个数字，并且不能大于指定的值
 *
 * @author jion
 */
public class MaxValidation {

    /**
     * .@Max(value) 必须是一个数字，并且不能大于指定的值
     */
    @Max(value = 100, message = "BigDecimal不能大于100")
    public BigDecimal bigDecimalMax;

    @Max(value = 100, message = "BigInteger不能大于100")
    public BigInteger bigIntegerMax;

    @Max(value = 100, message = "CharSequence不能大于100")
    public CharSequence charSequenceMax;

    @Max(value = 100, message = "Byte不能大于100")
    public Byte byteMax;

    @Max(value = 100, message = "Short不能大于100")
    public Short shortMax;

    @Max(value = 100, message = "Short不能大于100")
    public Integer integerMax;

    @Max(value = 100, message = "Long不能大于100")
    public Long longMax;
}
