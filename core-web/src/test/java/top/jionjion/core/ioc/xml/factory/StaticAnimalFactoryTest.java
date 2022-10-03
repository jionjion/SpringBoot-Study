package top.jionjion.core.ioc.xml.factory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * 测试静态工厂方法获得Bean
 *
 * @author Jion
 */
@SpringBootTest
@ContextConfiguration(locations = "classpath:ioc/xml/bean-config.xml")
class StaticAnimalFactoryTest {

    @Autowired(required = false)
    Cat cat;

    @Test
    void test() {
        System.out.println("获得Bean:" + cat.toString());
    }
}