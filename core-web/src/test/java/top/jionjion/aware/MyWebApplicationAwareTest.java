package top.jionjion.aware;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Jion
 */
@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"web-application:true"})
public class MyWebApplicationAwareTest{

    @Autowired
    MyWebApplicationAware myWebApplicationAware;

    @Test
    public void getFlag() {
        Boolean flag = myWebApplicationAware.getFlag();
        System.out.println("通过Aware接口获得:" + flag);
    }
}