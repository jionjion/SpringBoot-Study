package top.jionjion.validation.jsr303.number;

import org.junit.jupiter.api.Test;
import top.jionjion.validation.ValidationBaseTest;

import java.math.BigDecimal;
import java.math.BigInteger;

class NegativeOrZeroValidationTest extends ValidationBaseTest {

    @Test
    void test() {
        NegativeOrZeroValidation obj = new NegativeOrZeroValidation();
        obj.bigDecimalNegativeOrZero = BigDecimal.valueOf(1);
        obj.bigIntegerNegativeOrZero = BigInteger.valueOf(1);
        obj.charSequenceNegativeOrZero = "1";
        obj.byteNegativeOrZero = (byte) 1;
        obj.shortNegativeOrZero = (short) 1;
        obj.integerNegativeOrZero = 1;
        obj.longNegativeOrZero = 1L;
        // 必须为负数或者0 fail
        super.validate(obj);
    }
}