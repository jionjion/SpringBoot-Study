package top.jionjion.core.ioc.annotation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试,通过 @Configuration 结合 @Bean 注入Bean
 *
 * @author Jion
 */
@SpringBootTest
class BeanConfigTest {

    @Autowired
    Dog dog;

    @Test
    void test() {
        System.out.println("获得Bean:" + dog);
    }
}