package top.jionjion.validation.hibernate.objects;

import org.junit.jupiter.api.Test;
import top.jionjion.validation.ValidationBaseTest;

/**
 * 通用对象校验
 * .@EAN 必须为EAN商品编码,商品后面一维码编号.不能有空格
 *
 * @author jion
 */
class EanValidationTest extends ValidationBaseTest {

    @Test
    void test(){
        EanValidation obj = new EanValidation();
        // ENA商品编码 pass
        obj.mustEan = "6920203819046";

        super.validate(obj);
    }
}