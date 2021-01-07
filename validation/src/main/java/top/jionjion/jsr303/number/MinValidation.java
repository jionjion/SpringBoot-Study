package top.jionjion.jsr303.number;

import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 数字校验
 * .@Min(value) 必须是数字，并且不能小于指定的值
 *
 * @author jion
 */
public class MinValidation {

    /**
     * .@Min(value) 必须是数字，并且不能小于指定的值
     */
    @Min(value = 0, message = "BigDecimal不能小于0")
    public BigDecimal bigDecimalMin;

    @Min(value = 0, message = "BigInteger不能小于0")
    public BigInteger bigIntegerMin;

    @Min(value = 0, message = "CharSequence不能小于0")
    public CharSequence charSequenceMin;

    @Min(value = 0, message = "Byte不能小于0")
    public Byte byteMin;

    @Min(value = 0, message = "Short不能小于0")
    public Short shortMin;

    @Min(value = 0, message = "Short不能小于0")
    public Integer integerMin;

    @Min(value = 0, message = "Long不能小于0")
    public Long longMin;
}
