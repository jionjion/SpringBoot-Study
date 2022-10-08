package top.jionjion.validation.jsr303.objects;

import org.junit.jupiter.api.Test;
import top.jionjion.validation.ValidationBaseTest;

import java.util.Collections;

class SizeValidationTest extends ValidationBaseTest {

    @Test
    void note() {
        SizeValidation obj = new SizeValidation();
        obj.collectionLimitSize = null;
        obj.arrayLimitSize = null;
        obj.stringLimitSize = null;
        // 为null，不做校验 pass
        super.validate(obj);
    }

    @Test
    void mustEmail1() {
        SizeValidation obj = new SizeValidation();
        obj.collectionLimitSize = Collections.singleton(null);
        // 成员数量为1 pass
        super.validate(obj);
    }

    @Test
    void arrayLimitSize1() {
        SizeValidation obj = new SizeValidation();
        obj.arrayLimitSize = new Object[] {};
        // 成员数量为0 pass
        super.validate(obj);
    }

    @Test
    void stringLimitSize1() {
        SizeValidation obj = new SizeValidation();
        obj.stringLimitSize = "";
        // 空串 false
        super.validate(obj);
    }

    @Test
    void stringLimitSize2() {
        SizeValidation obj = new SizeValidation();
        obj.stringLimitSize = "    ";
        // 空格串 pass
        super.validate(obj);
    }
}