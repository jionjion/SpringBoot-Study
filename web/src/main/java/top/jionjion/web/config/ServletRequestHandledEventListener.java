package top.jionjion.web.config;

import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

import java.util.logging.Logger;

/**
 * 监听拦截请求
 *
 * @author Jion
 */
@Component
public class ServletRequestHandledEventListener implements ApplicationListener<ServletRequestHandledEvent> {

    final Logger logger = Logger.getLogger(ServletRequestHandledEventListener.class.getName());

    @Override
    public void onApplicationEvent(@NonNull ServletRequestHandledEvent event) {
        logger.info(() -> "请求相关信息: " + event.getDescription());
        logger.info(() -> "访问路径: " + event.getRequestUrl());
        logger.info(() -> "请求系统响应花费时间: " + event.getProcessingTimeMillis());
        logger.info(() -> "请求发生时间: " + event.getTimestamp());
        logger.info(() -> "请求失败原因异常: " + event.getFailureCause());
        logger.info(() -> "请求响应HTTP状态值: " + event.getStatusCode());
    }
}

