package top.jionjion.quartz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Quartz 定时任务
 */
class QuartzApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> QuartzApplication.main(new String[]{""}));
    }

}
