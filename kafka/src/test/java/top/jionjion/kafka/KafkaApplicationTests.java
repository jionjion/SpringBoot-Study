package top.jionjion.kafka;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Kafka 使用测试
 */
class KafkaApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> KafkaApplication.main(new String[]{""}));
    }

}
