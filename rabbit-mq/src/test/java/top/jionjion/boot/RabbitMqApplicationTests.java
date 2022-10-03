package top.jionjion.boot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * RabbitMq 队列使用
 */
class RabbitMqApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> RabbitMqApplication.main(new String[]{""}));
    }

}
