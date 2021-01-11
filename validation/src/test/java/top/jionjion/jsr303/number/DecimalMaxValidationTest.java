package top.jionjion.jsr303.number;

import org.junit.jupiter.api.Test;
import top.jionjion.ValidationBaseTest;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Jion
 */
class DecimalMaxValidationTest extends ValidationBaseTest {

    @Test
    public void test() {
        DecimalMaxValidation obj = new DecimalMaxValidation();
        obj.bigDecimalLimitDecimalMax = BigDecimal.TEN;
        obj.bigIntegerLimitDecimalMax = BigInteger.TEN;
        obj.charSequenceLimitDecimalMax = "abc123";
        obj.byteLimitDecimalMax = (byte) 10;
        obj.shortLimitDecimalMax = (short) 10;
        obj.integerLimitDecimalMax = 10;
        obj.longLimitDecimalMax = 10L;
        // 不能超过1 fail
        super.validate(obj);
    }
}