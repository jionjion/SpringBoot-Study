package top.jionjion.validation.hibernate.objects;

import org.junit.jupiter.api.Test;
import top.jionjion.validation.ValidationBaseTest;

/**
 * 通用对象校验
 * .@CreditCardNumber 必须为一个信用卡编码
 *
 * @author jion
 */
class CreditCardNumberValidationTest extends ValidationBaseTest {

    @Test
    void test(){
        CreditCardNumberValidation obj = new CreditCardNumberValidation();
        // 信用卡编码 fail
        obj.mustCreditCardNumber = "12345678908765432";
        super.validate(obj);
    }
}
