package top.jionjion.validation.jsr303.asserts;

import org.junit.jupiter.api.Test;
import top.jionjion.validation.ValidationBaseTest;

/**
 * @author Jion
 */
class AssertFalseValidationTest extends ValidationBaseTest {

    @Test
    void mustFalse() {
        AssertFalseValidation obj = new AssertFalseValidation();
        obj.mustFalse = Boolean.TRUE;
        // 必须为false fail
        super.validate(obj);
    }
}