package top.jionjion.thymeleaf;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ThymeleafApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> ThymeleafApplication.main(new String[]{""}));
    }

}
