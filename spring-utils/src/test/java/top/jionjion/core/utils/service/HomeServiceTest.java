package top.jionjion.core.utils.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Jion
 */
@SpringBootTest
class HomeServiceTest {

    @Autowired
    HomeService homeService;

    @Test
    void hello(){
        homeService.hello("Jion");
    }

    @Test
    void say(){
        homeService.say();
    }
}