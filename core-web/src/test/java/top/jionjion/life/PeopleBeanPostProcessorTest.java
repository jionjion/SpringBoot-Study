package top.jionjion.life;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 *  测试 InstantiationAwareBeanPostProcessor 在类初始化时/后进行修改
 * @author Jion
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PeopleBeanPostProcessorTest {

    @Autowired
    People people;

    @Test
    public void test(){
        System.out.println("获得Bean: " + people);
    }
}