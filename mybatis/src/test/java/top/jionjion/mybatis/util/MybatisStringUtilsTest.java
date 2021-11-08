package top.jionjion.mybatis.util;

import org.junit.jupiter.api.Test;
import top.jionjion.mybatis.util.MybatisStringUtils;

/**
 * @author Jion
 */
class MybatisStringUtilsTest {

    @Test
    void toUpperCase() {
        System.out.println(MybatisStringUtils.toUpperCase("abc"));
    }

    @Test
    void returnA() {
        System.out.println(MybatisStringUtils.returnA());
    }
}