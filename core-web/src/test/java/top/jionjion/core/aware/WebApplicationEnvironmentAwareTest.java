package top.jionjion.core.aware;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Jion
 */
@SpringBootTest
class WebApplicationEnvironmentAwareTest {

    @Autowired
    WebApplicationEnvironmentAware webApplicationEnvironmentAware;

    @Test
    void getOne() {
        webApplicationEnvironmentAware.getOne();
    }
}