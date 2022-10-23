package top.jionjion.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * 项目定制 SpringMVC
 *
 * @author Jion
 */
@Configuration
public class WebMvcConfigurationCustomization extends WebMvcConfigurationSupport {

    final Logger logger = Logger.getLogger(WebMvcConfigurationCustomization.class.getName());

    /**
     * 添加自定义内容转换器
     *
     * @param converters 要向其中添加消息转换器的列表(最初是一个空列表)
     */
    @Override
    protected void configureMessageConverters(@NonNull List<HttpMessageConverter<?>> converters) {
        logger.info(() -> "自定义配置转换类: " + Arrays.toString(converters.toArray()));
        super.configureMessageConverters(converters);
    }
}
