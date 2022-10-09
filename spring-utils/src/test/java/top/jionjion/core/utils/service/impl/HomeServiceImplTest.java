package top.jionjion.core.utils.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Jion
 */
@SpringBootTest
class HomeServiceImplTest {

    @Autowired
    HomeServiceImpl homeService;

    @Test
    void hello() {
        homeService.hello("Jion");
    }

    @Test
    void say() {
        homeService.say();
    }

    @Test
    void page() {
        homeService.setPage(homeService.getPage());
        System.out.println( homeService.getPage());
    }
}