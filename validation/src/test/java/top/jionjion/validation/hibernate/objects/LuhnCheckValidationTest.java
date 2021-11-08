package top.jionjion.validation.hibernate.objects;

import org.junit.jupiter.api.Test;
import top.jionjion.validation.ValidationBaseTest;

/**
 * @author Jion
 */
class LuhnCheckValidationTest extends ValidationBaseTest {

    @Test
    public void test(){
        LuhnCheckValidation obj = new LuhnCheckValidation();
        // 假身份证 fail
        obj.mustLuhnCheck = "410603180004123533";
        super.validate(obj);
    }
}