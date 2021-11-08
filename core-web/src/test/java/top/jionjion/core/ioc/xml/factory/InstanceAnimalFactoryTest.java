package top.jionjion.core.ioc.xml.factory;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

/**
 * 测试实例工厂方法获得Bean
 *
 * @author Jion
 */
@SpringBootTest
@ContextConfiguration(locations = "classpath:ioc/xml/bean-config.xml")
public class InstanceAnimalFactoryTest {

    @Resource
    Cat cat;

    @Test
    public void test() {
        System.out.println("获得Bean:" + cat.toString());
    }
}