package top.jionjion.jsr303.objects;

import org.junit.jupiter.api.Test;
import top.jionjion.jsr303.JSR303BaseTest;

class PatternValidationTest extends JSR303BaseTest {


    @Test
    public void mustEmail1() {
        PatternValidation obj = new PatternValidation();
        obj.mustPattern = "abc";
        // 非数字 fail
        super.validate(obj);
    }
}