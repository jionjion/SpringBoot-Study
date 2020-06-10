package top.jionjion.di;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Jion
 */

@RunWith(SpringRunner.class)
@SpringBootApplication(scanBasePackages = "top.jionjion.di")
public class AppControllerTest {

    @Autowired(required = false)
    private AppController appController;

    @Test
    public void testSave(){
        appController.save();
    }
}