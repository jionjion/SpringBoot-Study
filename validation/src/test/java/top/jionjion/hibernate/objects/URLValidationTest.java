package top.jionjion.hibernate.objects;

import org.junit.jupiter.api.Test;
import top.jionjion.ValidationBaseTest;

/**
 * 通用对象校验
 * .@URL 必须为URL格式
 *
 * @author jion
 */
class URLValidationTest extends ValidationBaseTest {

    @Test
    public void test(){
        URLValidation obj = new URLValidation();
        // URL格式 fail
        obj.mustURL = "12345";

        super.validate(obj);
    }
}