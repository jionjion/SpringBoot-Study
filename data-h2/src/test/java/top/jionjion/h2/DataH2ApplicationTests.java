package top.jionjion.h2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DataH2ApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> DataH2Application.main(new String[]{""}));
    }
}
