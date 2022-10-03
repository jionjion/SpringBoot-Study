package top.jionjion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SecurityTokenApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> SecurityTokenApplication.main(new String[]{""}));
    }

}
