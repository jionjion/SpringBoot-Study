package top.jionjion.aware;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Jion
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WebApplicationEnvironmentAwareTest {

    @Autowired
    WebApplicationEnvironmentAware webApplicationEnvironmentAware;

    @Test
    public void getOne() {
        webApplicationEnvironmentAware.getOne();
    }
}