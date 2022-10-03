package top.jionjion.json;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * JSON 工具类单元测试
 */
class JsonApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> JsonApplication.main(new String[]{""}));
    }

}
