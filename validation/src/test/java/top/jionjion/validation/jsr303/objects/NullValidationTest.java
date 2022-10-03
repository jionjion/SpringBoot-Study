package top.jionjion.validation.jsr303.objects;

import org.junit.jupiter.api.Test;
import top.jionjion.validation.ValidationBaseTest;

/**
 * .@Null 必须为 null
 *
 * @author Jion
 */
class NullValidationTest extends ValidationBaseTest {

    @Test
    void mustNull1() {
        NullValidation obj = new NullValidation();
        obj.mustNull = new Object();
        // 对象必须为空 fail
        super.validate(obj);
    }
}