package top.jionjion.hibernate.objects;

import org.junit.jupiter.api.Test;
import top.jionjion.ValidationBaseTest;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 通用对象校验
 * .@Range 在指定范围内数字,或者数字字符串
 *
 * @author jion
 */
class RangeValidationTest extends ValidationBaseTest {

    @Test
    public void test(){
        RangeValidation obj = new RangeValidation();
        obj.mustStringRange = "10";
        obj.mustBigDecimalRange = BigDecimal.TEN;
        obj.mustBigIntegerRange = BigInteger.TEN;
        obj.mustByteRange = (byte) 10;
        obj.mustShortRange = (short) 10;
        obj.mustIntegerRange = 10;
        obj.mustLongRange = 10L;

        // fail
        super.validate(obj);
    }
}