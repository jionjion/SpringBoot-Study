package top.jionjion.validation.hibernate.objects;

import org.junit.jupiter.api.Test;
import top.jionjion.validation.ValidationBaseTest;

/**
 * 通用对象校验
 * .@Length 指定字符串的长度在范围内
 *
 * @author jion
 */
class LengthValidationTest extends ValidationBaseTest {

    @Test
    void test(){
        LengthValidation obj = new LengthValidation();
        // 字符串长度在[0,10]之间 pass
        obj.mustLength = "12345678901";
        super.validate(obj);
    }
}