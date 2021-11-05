package top.jionjion.web.ioc.annotation.factory;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import top.jionjion.web.ioc.annotation.factory.Duck;
import top.jionjion.web.ioc.annotation.factory.DuckImportBeanDefinitionRegistrar;

import javax.annotation.Resource;

/**
 *  使用 ImportBeanDefinitionRegistrar 注入Bean
 * @author Jion
 */
@SpringBootTest
@Import(DuckImportBeanDefinitionRegistrar.class)
public class DuckImportBeanDefinitionRegistrarTest {

    @Resource
    Duck duck;

    @Test
    public void test(){
        System.out.println("获得Bean:" + duck);
    }
}