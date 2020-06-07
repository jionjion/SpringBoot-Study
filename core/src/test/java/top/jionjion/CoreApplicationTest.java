package top.jionjion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Jion
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CoreApplicationTest {

    @Test
    public void test(){
        System.out.println("启动成功!");
    }

}