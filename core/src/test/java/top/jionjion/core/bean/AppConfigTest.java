package top.jionjion.core.bean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *  @author Jion
 *      测试创建Bean和自定义Bean的生命周期
 */
@SpringBootTest
@SpringBootApplication(scanBasePackages = "top.jionjion.bean")
public class AppConfigTest {

    @Autowired
    private AppConfig appConfig;

    @Autowired(required = false)
    private User user;

    @Test
    public void testGetUser(){
        User user = appConfig.getUser();
        System.out.println(user.hashCode());
    }

    @Test
    public void testUser(){
        System.out.println(user.hashCode());
    }
}