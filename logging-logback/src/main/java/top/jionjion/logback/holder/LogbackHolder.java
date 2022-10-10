package top.jionjion.logback.holder;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

/**
 * 动态配置 Logback 的 Logger 实例
 *
 * @author Jion
 */
public class LogbackHolder {

    private LogbackHolder() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * @param name logger的名字, 作为日志前缀
     * @return logger实例
     */
    public static Logger getLogger(String name) {
        // 上下文
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        // 是否已经创建过 logger 对象
        if (loggerContext.exists(name) == null) {
            // 不存在自行创建
            return buildLogger(name);
        }
        return loggerContext.getLogger(name);
    }

    /**
     * 自行创建 logger 对象
     *
     * @param name logger的名字, 作为日志前缀
     * @return logger实例
     */
    private static Logger buildLogger(String name) {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        // 初始化环境,不存在则创建
        Logger logger = loggerContext.getLogger(name);

        // 配置 RollingFileAppender
        RollingFileAppender<ILoggingEvent> rollingFileAppender = new RollingFileAppender<>();
        rollingFileAppender.setName("CUSTOM");
        rollingFileAppender.setContext(loggerContext);

        // 配置 RollingPolicy
        TimeBasedRollingPolicy<?> rollingPolicy = new TimeBasedRollingPolicy<>();
        rollingPolicy.setFileNamePattern("temp/log" + name + ".%d{yyyyMM}.log");
        rollingPolicy.setParent(rollingFileAppender);
        rollingPolicy.setContext(loggerContext);
        rollingPolicy.start();

        // 配置 Encoder
        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setCharset(StandardCharsets.UTF_8);
        encoder.setPattern("%msg%n");
        encoder.setContext(loggerContext);
        encoder.start();

        // 关联
        rollingFileAppender.setRollingPolicy(rollingPolicy);
        rollingFileAppender.setEncoder(encoder);
        rollingFileAppender.start();

        logger.addAppender(rollingFileAppender);
        return logger;
    }
}
