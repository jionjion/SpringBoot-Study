package top.jionjion.core.aware;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Jion
 */
@SpringBootTest(properties = {"web-application=true"})
class MyWebApplicationAwareTest {

    @Autowired
    MyWebApplicationAware myWebApplicationAware;

    @Test
    void getFlag() {
        Boolean flag = myWebApplicationAware.getFlag();
        System.out.println("通过Aware接口获得:" + flag);
    }
}