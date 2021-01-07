package top.jionjion.jsr303.number;

import org.junit.jupiter.api.Test;
import top.jionjion.jsr303.JSR303BaseTest;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Jion
 */
class DecimalMaxValidationTest extends JSR303BaseTest {

    @Test
    public void test() {
        DecimalMaxValidation obj = new DecimalMaxValidation();
        obj.bigDecimalLimitDecimalMax = BigDecimal.TEN;
        obj.bigIntegerLimitDecimalMax = BigInteger.TEN;
        obj.charSequenceLimitDecimalMax = "abc123";
        obj.byteLimitDecimalMax = (byte) 10;
        obj.shortLimitDecimalMax = (short) 10;
        obj.intLimitDecimalMax = 10;
        obj.longLimitDecimalMax = 10L;
        // 不能超过1 fail
        super.validate(obj);
    }
}