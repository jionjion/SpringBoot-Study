package top.jionjion.jsr303.objects;

import org.junit.jupiter.api.Test;
import top.jionjion.ValidationBaseTest;

class EmailValidationTest extends ValidationBaseTest {

    @Test
    public void mustEmail1() {
        EmailValidation obj = new EmailValidation();
        obj.mustEmail = "12345678";
        // 非邮箱 fail
        super.validate(obj);
    }

    @Test
    public void mustEmail2() {
        EmailValidation obj = new EmailValidation();
        obj.mustEmail = "123@qq.com";
        // 邮箱 pass
        super.validate(obj);
    }
}