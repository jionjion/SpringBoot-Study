package top.jionjion.jsr303.objects;

import org.junit.jupiter.api.Test;
import top.jionjion.ValidationBaseTest;

class PatternValidationTest extends ValidationBaseTest {


    @Test
    public void mustEmail1() {
        PatternValidation obj = new PatternValidation();
        obj.mustPattern = "abc";
        // 非数字 fail
        super.validate(obj);
    }
}