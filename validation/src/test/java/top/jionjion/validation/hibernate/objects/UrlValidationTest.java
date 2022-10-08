package top.jionjion.validation.hibernate.objects;

import org.junit.jupiter.api.Test;
import top.jionjion.validation.ValidationBaseTest;

/**
 * 通用对象校验
 * .@URL 必须为URL格式
 *
 * @author jion
 */
class UrlValidationTest extends ValidationBaseTest {

    @Test
    void test(){
        UrlValidation obj = new UrlValidation();
        // URL格式 fail
        obj.mustUrl = "12345";

        super.validate(obj);
    }
}