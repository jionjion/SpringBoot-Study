package top.jionjion.jsr303.asserts;

import org.junit.jupiter.api.Test;
import top.jionjion.ValidationBaseTest;

/**
 * @author Jion
 */
class AssertTrueValidationTest extends ValidationBaseTest {

    @Test
    public void mustFalse() {
        AssertTrueValidation obj = new AssertTrueValidation();
        obj.mustTrue = Boolean.FALSE;
        // 必须为true fail
        super.validate(obj);
    }
}