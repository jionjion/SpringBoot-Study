package top.jionjion.jsr303.asserts;

import org.junit.jupiter.api.Test;
import top.jionjion.jsr303.JSR303BaseTest;
import top.jionjion.jsr303.objects.EmailValidation;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jion
 */
class AssertFalseValidationTest extends JSR303BaseTest {

    @Test
    public void mustFalse() {
        AssertFalseValidation obj = new AssertFalseValidation();
        obj.mustFalse = Boolean.TRUE;
        // 必须为false fail
        super.validate(obj);
    }
}