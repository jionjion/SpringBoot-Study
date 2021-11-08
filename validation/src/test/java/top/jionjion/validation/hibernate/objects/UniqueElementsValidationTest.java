package top.jionjion.validation.hibernate.objects;

import org.junit.jupiter.api.Test;
import top.jionjion.validation.ValidationBaseTest;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * 通用对象校验
 * .@UniqueElements 集合必须没有重复
 *
 * @author jion
 */
class UniqueElementsValidationTest extends ValidationBaseTest {

    @Test
    public void test() {
        UniqueElementsValidation obj = new UniqueElementsValidation();
        obj.mustCollectionUniqueElements = Collections.singletonList("A");
        obj.mustListUniqueElements = List.of("A", "B", "C", "C");
        obj.mustSetUniqueElements = Set.of("A", "B", "C");
        // fail
        super.validate(obj);
    }
}