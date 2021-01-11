package top.jionjion.jsr303.objects;

import org.junit.jupiter.api.Test;
import top.jionjion.ValidationBaseTest;

import java.util.Collections;

/**
 * 通用对象校验
 *  .@NotEmpty 集合, 数组, 字符不能为空
 *
 * @author jion
 */
class NotEmptyValidationTest extends ValidationBaseTest {

    @Test
    public void collectionMustNotEmpty1() {
        NotEmptyValidation obj = new NotEmptyValidation();
        obj.collectionMustNotEmpty = Collections.singleton(null);
        // 只有一个空成员的集合 pass
        super.validate(obj);
    }

    @Test
    public void collectionMustNotEmpty2() {
        NotEmptyValidation obj = new NotEmptyValidation();
        // 空集合 fail
        obj.collectionMustNotEmpty = Collections.EMPTY_SET;
        super.validate(obj);
        obj.collectionMustNotEmpty = Collections.EMPTY_LIST;
        super.validate(obj);
    }

    @Test
    public void collectionMustNotEmpty3() {
        NotEmptyValidation obj = new NotEmptyValidation();
        obj.collectionMustNotEmpty = null;
        // 空对象 fail
        super.validate(obj);
    }

    @Test
    public void arrayMustNotEmpty1() {
        NotEmptyValidation obj = new NotEmptyValidation();
        obj.arrayMustNotEmpty = new Object[] {};
        //  fail
        super.validate(obj);
    }

    @Test
    public void mustStringNotEmpty1() {
        NotEmptyValidation obj = new NotEmptyValidation();
        //  空串 fail
        obj.mustStringNotEmpty = "";
        super.validate(obj);
    }

    @Test
    public void mustStringNotEmpty2() {
        NotEmptyValidation obj = new NotEmptyValidation();
        //  空串 pass
        obj.mustStringNotEmpty = "  ";
        super.validate(obj);
    }
}