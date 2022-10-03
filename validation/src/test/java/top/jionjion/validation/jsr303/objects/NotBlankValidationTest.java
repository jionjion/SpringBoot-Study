package top.jionjion.validation.jsr303.objects;

import org.junit.jupiter.api.Test;
import top.jionjion.validation.ValidationBaseTest;

class NotBlankValidationTest extends ValidationBaseTest {

    @Test
    void mustNotBlank1() {
        NotBlankValidation obj = new NotBlankValidation();
        obj.mustNotBlank = "";
        // 非空串 fail
        super.validate(obj);
    }

    @Test
    void mustNotBlank2() {
        NotBlankValidation obj = new NotBlankValidation();
        obj.mustNotBlank = "  ";
        // 空格的空串 fail
        super.validate(obj);
    }

    @Test
    void mustNotBlank3() {
        NotBlankValidation obj = new NotBlankValidation();
        obj.mustNotBlank = null;
        // 空 fail
        super.validate(obj);
    }
}