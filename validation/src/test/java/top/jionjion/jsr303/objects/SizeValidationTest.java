package top.jionjion.jsr303.objects;

import org.junit.jupiter.api.Test;
import top.jionjion.jsr303.JSR303BaseTest;

import java.util.Collections;

class SizeValidationTest extends JSR303BaseTest {

    @Test
    public void note() {
        SizeValidation obj = new SizeValidation();
        obj.collectionLimitSize = null;
        obj.arrayLimitSize = null;
        obj.stringLimitSize = null;
        // 为null，不做校验 pass
        super.validate(obj);
    }

    @Test
    public void mustEmail1() {
        SizeValidation obj = new SizeValidation();
        obj.collectionLimitSize = Collections.singleton(null);
        // 成员数量为1 pass
        super.validate(obj);
    }

    @Test
    public void arrayLimitSize1() {
        SizeValidation obj = new SizeValidation();
        obj.arrayLimitSize = new Object[] {};
        // 成员数量为0 pass
        super.validate(obj);
    }

    @Test
    public void stringLimitSize1() {
        SizeValidation obj = new SizeValidation();
        obj.stringLimitSize = "";
        // 空串 false
        super.validate(obj);
    }

    @Test
    public void stringLimitSize2() {
        SizeValidation obj = new SizeValidation();
        obj.stringLimitSize = "    ";
        // 空格串 pass
        super.validate(obj);
    }
}