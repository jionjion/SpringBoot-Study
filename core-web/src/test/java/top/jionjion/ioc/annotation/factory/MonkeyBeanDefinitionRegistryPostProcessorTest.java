package top.jionjion.ioc.annotation.factory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *  测试 BeanDefinitionRegistryPostProcessor 注入Bean
 * @author Jion
 */
@SpringBootTest
public class MonkeyBeanDefinitionRegistryPostProcessorTest {

    @Autowired
    @Qualifier("monkey")
    private Animal monkey;

    @Test
    public void test(){
        System.out.println("获得Bean:" + monkey);
    }
}