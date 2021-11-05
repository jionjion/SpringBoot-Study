package top.jionjion.web.starter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.jionjion.web.starter.UseWeatherService;

/**
 * @author Jion
 */
@SpringBootTest
public class UseWeatherServiceTest {

    @Autowired
    UseWeatherService useWeatherService;

    @Test
    public void getType(){
        String type = useWeatherService.getType();
        System.out.println("天气状态>> " + type);
    }
}