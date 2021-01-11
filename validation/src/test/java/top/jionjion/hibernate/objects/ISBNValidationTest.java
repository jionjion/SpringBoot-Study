package top.jionjion.hibernate.objects;

import org.junit.jupiter.api.Test;
import top.jionjion.ValidationBaseTest;

/**
 * 通用对象校验
 * .@ISBN 必须为ISBN图书编码.是否携带 - 无所谓
 *
 * @author jion
 */
class ISBNValidationTest extends ValidationBaseTest {


    @Test
    public void test(){
        ISBNValidation obj = new ISBNValidation();
        // ISBN图书编码 pass
        //obj.isbn = "978-7-5386-8713-2";
        obj.mustISBN = "9787538687132";
        super.validate(obj);
    }
}