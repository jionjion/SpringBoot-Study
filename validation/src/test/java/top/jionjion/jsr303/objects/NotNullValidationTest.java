package top.jionjion.jsr303.objects;

import org.junit.jupiter.api.Test;
import top.jionjion.jsr303.JSR303BaseTest;

/**
 * 通用对象校验
 * .@NotNull 必须不为 null
 *
 * @author jion
 */
class NotNullValidationTest extends JSR303BaseTest {

    @Test
    public void mustNotNull1() {
        NotNullValidation obj = new NotNullValidation();
        obj.mustNotNull = null;
        // 对象必须非空 fail
        super.validate(obj);
    }
}