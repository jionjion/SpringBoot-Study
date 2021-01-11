package top.jionjion.validation;

import org.junit.jupiter.api.Test;
import top.jionjion.ValidationBaseTest;

/**
 * 使用自定义注解
 * .@NotContainSpace 自定义注解
 *
 * @author Jion
 */
class NotContainSpaceValidationTest extends ValidationBaseTest {

    @Test
    public void test() {
        NotContainSpaceValidation obj = new NotContainSpaceValidation();
        obj.name = "A B C";

        super.validate(obj);
    }
}