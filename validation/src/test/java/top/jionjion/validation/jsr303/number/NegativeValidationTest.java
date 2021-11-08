package top.jionjion.validation.jsr303.number;

import org.junit.jupiter.api.Test;
import top.jionjion.validation.ValidationBaseTest;

import java.math.BigDecimal;
import java.math.BigInteger;

class NegativeValidationTest extends ValidationBaseTest {

    @Test
    public void test() {
        NegativeValidation obj = new NegativeValidation();
        obj.bigDecimalNegative = BigDecimal.valueOf(0);
        obj.bigIntegerNegative = BigInteger.valueOf(1);
        obj.charSequenceNegative = "1";
        obj.byteNegative = (byte) 0;
        obj.shortNegative = (short) 0;
        obj.integerNegative = 0;
        obj.longNegative = 1L;
        // 必须为负数 fail
        super.validate(obj);
    }
}