package top.jionjion.hibernate.objects;

import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 通用对象校验
 * .@Range 在指定范围内数字,或者数字字符串
 *
 * @author jion
 */
public class RangeValidation {

    /**
     * .@Range 在指定范围内数字,或者数字字符串
     */
    @Range(min = 1L, max = 5L, message = "CharSequence不在[1,5]范围")
    public CharSequence mustStringRange;

    @Range(min = 1L, max = 5L, message = "BigDecimal不在[1,5]范围")
    public BigDecimal mustBigDecimalRange;

    @Range(min = 1L, max = 5L, message = "BigInteger不在[1,5]范围")
    public BigInteger mustBigIntegerRange;

    @Range(min = 1L, max = 5L, message = "Byte不在[1,5]范围")
    public Byte mustByteRange;

    @Range(min = 1L, max = 5L, message = "Short不在[1,5]范围")
    public Short mustShortRange;

    @Range(min = 1L, max = 5L, message = "Integer不在[1,5]范围")
    public Integer mustIntegerRange;

    @Range(min = 1L, max = 5L, message = "Long不在[1,5]范围")
    public Long mustLongRange;

}
