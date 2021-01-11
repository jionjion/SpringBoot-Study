package top.jionjion.jsr303.objects;

import org.junit.jupiter.api.Test;
import top.jionjion.ValidationBaseTest;

class NotBlankValidationTest extends ValidationBaseTest {

    @Test
    public void mustNotBlank1() {
        NotBlankValidation obj = new NotBlankValidation();
        obj.mustNotBlank = "";
        // 非空串 fail
        super.validate(obj);
    }

    @Test
    public void mustNotBlank2() {
        NotBlankValidation obj = new NotBlankValidation();
        obj.mustNotBlank = "  ";
        // 空格的空串 fail
        super.validate(obj);
    }

    @Test
    public void mustNotBlank3() {
        NotBlankValidation obj = new NotBlankValidation();
        obj.mustNotBlank = null;
        // 空 fail
        super.validate(obj);
    }
}