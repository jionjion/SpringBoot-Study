package top.jionjion.web.life;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.jionjion.web.life.People;

/**
 *  测试 InstantiationAwareBeanPostProcessor 在类初始化时/后进行修改
 * @author Jion
 */
@SpringBootTest
public class PeopleBeanPostProcessorTest {

    @Autowired
    People people;

    @Test
    public void test(){
        System.out.println("获得Bean: " + people);
    }
}