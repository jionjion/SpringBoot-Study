package top.jionjion.logback.holder;

import ch.qos.logback.classic.Logger;
import org.junit.jupiter.api.Test;

/**
 *  使用
 * @author Jion
 */
class LogbackHolderTest {

    @Test
    void test(){
        Logger logger = LogbackHolder.getLogger("jion");
        logger.error("这是错误消息....");
    }
}