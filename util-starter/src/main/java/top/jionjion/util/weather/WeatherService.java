package top.jionjion.util.weather;

/**
 * 对外提供服务
 *
 * @author Jion
 */
public class WeatherService {

    private final WeatherProperty weatherProperty;

    public WeatherService(WeatherProperty weatherProperty) {
        this.weatherProperty = weatherProperty;
    }

    /**
     * 获得天气情况
     */
    public String getType() {
        return weatherProperty.getType();
    }
}
