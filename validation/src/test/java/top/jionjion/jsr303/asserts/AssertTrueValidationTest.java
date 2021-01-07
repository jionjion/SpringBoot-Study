package top.jionjion.jsr303.asserts;

import org.junit.jupiter.api.Test;
import top.jionjion.jsr303.JSR303BaseTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jion
 */
class AssertTrueValidationTest extends JSR303BaseTest {

    @Test
    public void mustFalse() {
        AssertTrueValidation obj = new AssertTrueValidation();
        obj.mustTrue = Boolean.FALSE;
        // 必须为true fail
        super.validate(obj);
    }
}