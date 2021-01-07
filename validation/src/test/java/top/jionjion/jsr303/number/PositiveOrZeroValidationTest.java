package top.jionjion.jsr303.number;

import org.junit.jupiter.api.Test;
import top.jionjion.jsr303.JSR303BaseTest;

import java.math.BigDecimal;
import java.math.BigInteger;

class PositiveOrZeroValidationTest extends JSR303BaseTest {

    @Test
    public void test() {
        PositiveOrZeroValidation obj = new PositiveOrZeroValidation();
        obj.bigDecimalPositiveOrZero = BigDecimal.valueOf(-1);
        obj.bigIntegerPositiveOrZero = BigInteger.valueOf(-1);
        obj.charSequencePositiveOrZero = "-1";
        obj.bytePositiveOrZero = (byte) -1;
        obj.shortPositiveOrZero = (short) -1;
        obj.integerPositiveOrZero = -1;
        obj.longPositiveOrZero = -1L;
        // 必须为正数或者0 fail
        super.validate(obj);
    }
}