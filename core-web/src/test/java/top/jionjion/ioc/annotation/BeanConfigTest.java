package top.jionjion.ioc.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *  测试,通过 @Configuration 结合 @Bean 注入Bean
 * @author Jion
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BeanConfigTest {

    @Autowired
    Dog dog;

    @Test
    public void test() {
        System.out.println("获得Bean:" + dog);
    }
}