package top.jionjion.core.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志框架
 *
 * @author Jion
 */
public class LoggerUtil {

    final Logger logger = LoggerFactory.getLogger(LoggerUtil.class);

    public void logMessage(String message) {
        logger.debug(message);
    }
}
