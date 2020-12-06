package top.jionjion.log;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Jion
 */
@SpringBootTest
public class LoggerUtilTest {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void test(){
        logger.info("日志框架...");
    }
}