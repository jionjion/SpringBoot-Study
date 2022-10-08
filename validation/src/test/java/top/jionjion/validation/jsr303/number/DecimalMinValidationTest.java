package top.jionjion.validation.jsr303.number;

import org.junit.jupiter.api.Test;
import top.jionjion.validation.ValidationBaseTest;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Jion
 */
class DecimalMinValidationTest extends ValidationBaseTest {

    @Test
    void test() {
        DecimalMinValidation obj = new DecimalMinValidation();
        obj.bigDecimalLimitDecimalMin = BigDecimal.ZERO;
        obj.bigIntegerLimitDecimalMin = BigInteger.ZERO;
        obj.charSequenceLimitDecimalMin = "0";
        obj.byteLimitDecimalMin = (byte) 0;
        obj.shortLimitDecimalMin = (short) 0;
        obj.integerLimitDecimalMin = 0;
        obj.longLimitDecimalMin = 0L;
        // 不能小于1 fail
        super.validate(obj);
    }
}