package top.jionjion.redisom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RedisOmApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> RedisOmApplication.main(new String[]{""}));
    }

}
