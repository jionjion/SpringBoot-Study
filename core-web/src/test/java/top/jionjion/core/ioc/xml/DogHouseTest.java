package top.jionjion.core.ioc.xml;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * 使用XML方式,进行容器配置
 *
 * @author Jion
 */
@SpringBootTest
@ContextConfiguration(locations = "classpath:ioc/xml/bean-config.xml")
public class DogHouseTest {

    @Autowired
    DogHouse dogHouse;

    @Test
    public void test() {
        Dog dog = dogHouse.getDog();
        System.out.println("获得Bean:" + dog.toString());
    }
}