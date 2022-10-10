package top.jionjion.logback.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;
import top.jionjion.logback.exception.SomeException;

/**
 * 日志使用
 *
 * @author Jion
 */
@Service
@SuppressWarnings("unused")
public class SomeService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public void anything() {
        logger.trace("堆栈日志级别: {}, {}", "堆栈", "trace");
        logger.debug("调试日志级别: {}, {}", "调试", "debug");
        logger.info("信息日志级别: {}, {}", "信息", "info");
        logger.warn("警告日志级别: {}, {}", "警告", "warn");
        logger.error("错误日志级别: {}, {}", "错误", "error");
    }


    /**
     * 抛出自义定异常
     */
    public void throwException() {
        throw new SomeException("自定义异常");
    }

    /**
     * 抛出自义定异常,并指定关键字
     */
    public void throwExceptionForSift() {
        // 关键字, 根据关键字分发到不同的日志级别
        MDC.put("bizType", "service");
        throw new SomeException("自定义异常");
    }
}
