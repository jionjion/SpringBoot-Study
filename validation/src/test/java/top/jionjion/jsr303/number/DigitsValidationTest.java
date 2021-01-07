package top.jionjion.jsr303.number;

import org.junit.jupiter.api.Test;
import top.jionjion.jsr303.JSR303BaseTest;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Jion
 */
class DigitsValidationTest extends JSR303BaseTest {

    @Test
    public void test(){
        DigitsValidation obj = new DigitsValidation();
        obj.bigDecimalDigits = BigDecimal.ZERO;
        obj.bigIntegerDigits = BigInteger.ZERO;
        obj.charSequenceDigits = "0.9999";
        obj.byteDigits = (byte) 0;
        obj.shortDigits = (short) 0;
        obj.intDigits = 0;
        obj.longDigits = 0L;
        super.validate(obj);
    }
}