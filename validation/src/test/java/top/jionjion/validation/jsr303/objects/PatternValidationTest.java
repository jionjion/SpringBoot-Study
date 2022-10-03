package top.jionjion.validation.jsr303.objects;

import org.junit.jupiter.api.Test;
import top.jionjion.validation.ValidationBaseTest;

class PatternValidationTest extends ValidationBaseTest {


    @Test
    void mustEmail1() {
        PatternValidation obj = new PatternValidation();
        obj.mustPattern = "abc";
        // 非数字 fail
        super.validate(obj);
    }
}