package top.jionjion.validation.jsr303.number;

import org.junit.jupiter.api.Test;
import top.jionjion.validation.ValidationBaseTest;

import java.math.BigDecimal;
import java.math.BigInteger;

class MinValidationTest extends ValidationBaseTest {

    @Test
    void test(){
        MinValidation obj = new MinValidation();
        obj.bigDecimalMin = BigDecimal.valueOf(-110);
        obj.bigIntegerMin = BigInteger.valueOf(-110);
        obj.charSequenceMin = "-110";
        obj.byteMin = (byte) -110;
        obj.shortMin = (short) -110;
        obj.integerMin = -110;
        obj.longMin = -110L;
        // 最小值不能小于0 fail
        super.validate(obj);
    }
}