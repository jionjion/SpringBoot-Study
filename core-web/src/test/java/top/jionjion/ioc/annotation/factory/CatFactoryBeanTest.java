package top.jionjion.ioc.annotation.factory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *  测试 FactoryBean<T> 注入Bean
 * @author Jion
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CatFactoryBeanTest {

    @Autowired
    @Qualifier("cat") // 指定具体Bean
    private Animal cat;

    @Test
    public void test(){
        System.out.println("获得Bean:" + cat);
    }
}