package top.jionjion.hibernate.objects;

import org.junit.jupiter.api.Test;
import top.jionjion.ValidationBaseTest;

/**
 * @author Jion
 */
class CurrencyValidationTest extends ValidationBaseTest {

    @Test
    public void test(){
        CurrencyValidation obj = new CurrencyValidation();
        // 币种检测 fail
        obj.mustCurrency = "USD";

        super.validate(obj);
    }
}