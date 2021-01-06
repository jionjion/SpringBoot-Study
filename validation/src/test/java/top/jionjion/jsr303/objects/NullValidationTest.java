package top.jionjion.jsr303.objects;

import org.junit.jupiter.api.Test;
import top.jionjion.jsr303.JSR303BaseTest;

/**
 * @author Jion
 */
class NullValidationTest extends JSR303BaseTest {

    @Test
    public void test() {
        NullValidation obj = new NullValidation();
        obj.mustNull = new Object();
        // 对象必须为空
        super.validate(obj);
    }
}