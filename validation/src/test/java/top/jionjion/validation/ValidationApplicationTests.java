package top.jionjion.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidationApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> ValidationApplication.main(new String[]{""}));
    }

}
