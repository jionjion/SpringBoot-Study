package top.jionjion.util.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置类.
 * 指定配置信息类, 与自动注入的条件
 *
 * @author Jion
 */
@Configuration
@EnableConfigurationProperties(WeatherProperty.class)
@ConditionalOnProperty(name = "weather.enable", havingValue = "true")
public class WeatherAutoConfiguration {

    @Autowired
    private WeatherProperty weatherProperty;

    /**
     * 没有自定义服务时, 自动创建
     */
    @Bean
    @ConditionalOnMissingBean(WeatherService.class)
    public WeatherService weatherSource() {
        return new WeatherService(weatherProperty);
    }
}
