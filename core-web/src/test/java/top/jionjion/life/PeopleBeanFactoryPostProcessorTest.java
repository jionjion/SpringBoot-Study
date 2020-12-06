package top.jionjion.life;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *  测试 BeanFactoryPostProcessor 对已注册的Bean进行修改
 * @author Jion
 */
@SpringBootTest
public class PeopleBeanFactoryPostProcessorTest {

    @Autowired
    People people;

    @Test
    public void test(){
        System.out.println("获得Bean:" + people);
    }
}