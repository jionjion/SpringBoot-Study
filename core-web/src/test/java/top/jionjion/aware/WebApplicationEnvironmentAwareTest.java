package top.jionjion.aware;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Jion
 */
@SpringBootTest
public class WebApplicationEnvironmentAwareTest {

    @Autowired
    WebApplicationEnvironmentAware webApplicationEnvironmentAware;

    @Test
    public void getOne() {
        webApplicationEnvironmentAware.getOne();
    }
}