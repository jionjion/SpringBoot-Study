package top.jionjion.jsr303.asserts;

import org.junit.jupiter.api.Test;
import top.jionjion.ValidationBaseTest;

/**
 * @author Jion
 */
class AssertFalseValidationTest extends ValidationBaseTest {

    @Test
    public void mustFalse() {
        AssertFalseValidation obj = new AssertFalseValidation();
        obj.mustFalse = Boolean.TRUE;
        // 必须为false fail
        super.validate(obj);
    }
}