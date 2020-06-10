package top.jionjion.ioc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *  @author Jion
 *      测试SpringBoot的自动注入
 */
@RunWith(SpringRunner.class)
@SpringBootApplication(scanBasePackageClasses = {top.jionjion.ioc.AppConfig.class})
public class IocTest {

    @Autowired
    AppConfig appConfig;

    @Autowired
    AppRepository appRepository;

    @Autowired
    AppService appService;

    @Autowired
    AppController appController;

    @Test
    public void testAppConfig(){
        appConfig.save();
    }

    @Test
    public void testAppRepository(){
        appRepository.save();
    }

    @Test
    public void testAppService(){
        appService.save();
    }

    @Test
    public void testAppController(){
        appController.save();
    }
}