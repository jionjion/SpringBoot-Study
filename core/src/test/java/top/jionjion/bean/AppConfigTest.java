package top.jionjion.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *  @author Jion
 *      测试创建Bean和自定义Bean的生命周期
 */
@RunWith(SpringRunner.class)
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