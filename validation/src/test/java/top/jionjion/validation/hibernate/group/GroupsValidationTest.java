package top.jionjion.validation.hibernate.group;

import org.junit.jupiter.api.Test;
import top.jionjion.validation.ValidationBaseTest;

/**
 * 分组校验
 *
 * @author Jion
 */
class GroupsValidationTest extends ValidationBaseTest {

    @Test
    void testNoGroups() {
        GroupsValidation obj = new GroupsValidation();
        obj.id = null;
        // 触发注解,不指定分组条件,一定不会被校验.. 除非被重复标注,且不指定分组.
        super.validate(obj);
    }

    @Test
    void testUpdateGroups() {
        GroupsValidation obj = new GroupsValidation();
        obj.id = null;
        // 验证条件,只有在更新时校验才.  fail
        super.validate(obj, GroupsEnum.Update.class);
    }

    @Test
    void testInsertGroups() {
        GroupsValidation obj = new GroupsValidation();
        obj.id = null;
        // 验证条件,只有在更新时校验才.  pass
        super.validate(obj, GroupsEnum.Insert.class);
    }
}