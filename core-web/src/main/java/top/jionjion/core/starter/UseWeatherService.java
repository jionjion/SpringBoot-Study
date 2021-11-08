package top.jionjion.core.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.jionjion.util.weather.WeatherService;

/**
 * 使用自定义
 *
 * @author Jion
 */
@Component
public class UseWeatherService {

    @Autowired
    WeatherService weatherService;

    /**
     * 获得天气状态
     *
     * @return 状态
     */
    public String getType() {
        return weatherService.getType();
    }
}
