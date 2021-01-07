package top.jionjion.jsr303.number;

import org.junit.jupiter.api.Test;
import top.jionjion.jsr303.JSR303BaseTest;

import java.math.BigDecimal;
import java.math.BigInteger;

class PositiveValidationTest extends JSR303BaseTest {

    @Test
    public void test() {
        PositiveValidation obj = new PositiveValidation();
        obj.bigDecimalPositive = BigDecimal.valueOf(0);
        obj.bigIntegerPositive = BigInteger.valueOf(-1);
        obj.charSequencePositive = "-1";
        obj.bytePositive = (byte) 0;
        obj.shortPositive = (short) 0;
        obj.integerPositive = 0;
        obj.longPositive = -1L;
        // 必须为正数 fail
        super.validate(obj);
    }
}