package top.jionjion.web.ioc.xml.factory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import top.jionjion.web.ioc.xml.factory.Cat;

/**
 * 测试静态工厂方法获得Bean
 *
 * @author Jion
 */
@SpringBootTest
@ContextConfiguration(locations = "classpath:ioc/xml/bean-config.xml")
public class StaticAnimalFactoryTest {

    @Autowired
    Cat cat;

    @Test
    public void test() {
        System.out.println("获得Bean:" + cat.toString());
    }
}