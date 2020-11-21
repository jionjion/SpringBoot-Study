package top.jionjion.starter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Jion
 */
@RunWith(SpringRunner.class)
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