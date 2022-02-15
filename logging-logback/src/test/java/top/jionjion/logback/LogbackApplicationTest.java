package top.jionjion.logback;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class LogbackApplicationTest {

    final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 正常使用
     */
    @Test
    void logs() {
        logger.error("日志级别: {}, {}", "错误", "error");
        logger.warn("日志级别: {}, {}", "警告", "warn");
        logger.info("日志级别: {}, {}", "信息", "info");
        logger.debug("日志级别: {}, {}", "调试", "debug");
        logger.trace("日志级别: {}, {}", "堆栈", "trace");
    }

    /**
     * 自定义 MDC 标识符的日志
     * %X{REQUEST_ID} 使用
     */
    @Test
    void mdc() {
        MDC.put("REQUEST_ID", UUID.randomUUID().toString());
        logger.info("带有格式[REQUEST_ID]的请求");
    }

    /**
     * 日志上下文
     */
    @Test
    void contextLoads() {
        // 日志上下文
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(context);
    }
}