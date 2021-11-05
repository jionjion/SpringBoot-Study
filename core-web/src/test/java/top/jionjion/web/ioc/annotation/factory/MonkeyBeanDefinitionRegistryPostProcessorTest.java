package top.jionjion.web.ioc.annotation.factory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import top.jionjion.web.ioc.annotation.factory.AbstractAnimal;

/**
 *  测试 BeanDefinitionRegistryPostProcessor 注入Bean
 * @author Jion
 */
@SpringBootTest
public class MonkeyBeanDefinitionRegistryPostProcessorTest {

    @Autowired
    @Qualifier("monkey")
    private AbstractAnimal monkey;

    @Test
    public void test(){
        System.out.println("获得Bean:" + monkey);
    }
}