package top.jionjion.validation.hibernate.objects;

import org.junit.jupiter.api.Test;
import top.jionjion.validation.ValidationBaseTest;

import java.util.Date;

/**
 * 方法级别校验, 验证参数是否符合预期.
 * .@ParameterScriptAssert 注解
 *
 * @author Jion
 */
class ParameterScriptAssertValidationTest extends ValidationBaseTest {

    @Test
    void validationDate() {
        ParameterScriptAssertValidation obj = new ParameterScriptAssertValidation();
        obj.validationDate(new Date(System.currentTimeMillis() + 1000), new Date(System.currentTimeMillis()));
        super.validate(obj);
    }
}