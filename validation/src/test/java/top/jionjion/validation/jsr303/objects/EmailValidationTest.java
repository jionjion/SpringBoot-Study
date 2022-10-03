package top.jionjion.validation.jsr303.objects;

import org.junit.jupiter.api.Test;
import top.jionjion.validation.ValidationBaseTest;

class EmailValidationTest extends ValidationBaseTest {

    @Test
    void mustEmail1() {
        EmailValidation obj = new EmailValidation();
        obj.mustEmail = "12345678";
        // 非邮箱 fail
        super.validate(obj);
    }

    @Test
    void mustEmail2() {
        EmailValidation obj = new EmailValidation();
        obj.mustEmail = "123@qq.com";
        // 邮箱 pass
        super.validate(obj);
    }
}