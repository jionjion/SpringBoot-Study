package top.jionjion.validation.hibernate.objects;

import org.junit.jupiter.api.Test;
import top.jionjion.validation.ValidationBaseTest;

/**
 * 通用对象校验
 * .@ISBN 必须为ISBN图书编码.是否携带 - 无所谓
 *
 * @author jion
 */
class IsbnValidationTest extends ValidationBaseTest {


    @Test
    void test(){
        IsbnValidation obj = new IsbnValidation();
        // ISBN图书编码 pass
        //obj.isbn = "978-7-5386-8713-2";
        obj.mustIsbn = "9787538687132";
        super.validate(obj);
    }
}