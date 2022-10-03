package top.jionjion.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 单元测试
 */
class JunitApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> JunitApplication.main(new String[]{""}));
    }

}
