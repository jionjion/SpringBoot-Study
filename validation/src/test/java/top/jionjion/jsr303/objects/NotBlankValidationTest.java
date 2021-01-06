package top.jionjion.jsr303.objects;

import org.junit.jupiter.api.Test;
import top.jionjion.jsr303.JSR303BaseTest;

class NotBlankValidationTest extends JSR303BaseTest {

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