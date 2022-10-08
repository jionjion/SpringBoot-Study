package top.jionjion.validation.jsr303.number;

import org.junit.jupiter.api.Test;
import top.jionjion.validation.ValidationBaseTest;

import java.math.BigDecimal;
import java.math.BigInteger;

class MaxValidationTest extends ValidationBaseTest {

    @Test
    void test(){
        MaxValidation obj = new MaxValidation();
        obj.bigDecimalMax = BigDecimal.valueOf(110);
        obj.bigIntegerMax = BigInteger.valueOf(110);
        obj.charSequenceMax = "110";
        obj.byteMax = (byte) 110;
        obj.shortMax = (short) 110;
        obj.integerMax = 110;
        obj.longMax = 110L;
        // 最大值不能超过100 fail
        super.validate(obj);
    }
}