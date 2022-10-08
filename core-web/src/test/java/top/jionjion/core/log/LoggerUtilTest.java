package top.jionjion.core.log;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Jion
 */
@SpringBootTest
class LoggerUtilTest {

    final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void test(){
        logger.info("日志框架...");
    }
}