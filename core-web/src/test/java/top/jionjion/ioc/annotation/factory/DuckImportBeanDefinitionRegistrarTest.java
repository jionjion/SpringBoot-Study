package top.jionjion.ioc.annotation.factory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *  使用 ImportBeanDefinitionRegistrar 注入Bean
 * @author Jion
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(DuckImportBeanDefinitionRegistrar.class)
public class DuckImportBeanDefinitionRegistrarTest {

    @Autowired
    Duck duck;

    @Test
    public void test(){
        System.out.println("获得Bean:" + duck);
    }
}