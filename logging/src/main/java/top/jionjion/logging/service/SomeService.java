package top.jionjion.logging.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 日志使用
 *
 * @author Jion
 */
@Service
public class SomeService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public void anything() {
        logger.error("日志级别: {}, {}", "错误", "error");
        logger.warn("日志级别: {}, {}", "警告", "warn");
        logger.info("日志级别: {}, {}", "信息", "info");
        logger.debug("日志级别: {}, {}", "调试", "debug");
        logger.trace("日志级别: {}, {}", "堆栈", "trace");
    }
}
