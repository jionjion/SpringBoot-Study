package top.jionjion.swagger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SwaggerApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> SwaggerApplication.main(new String[]{""}));
    }

}
