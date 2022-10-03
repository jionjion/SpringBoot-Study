package top.jionjion.release;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 测试SpringBoot预发布版本
 */
class ReleaseApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> ReleaseApplication.main(new String[]{""}));
    }

}
