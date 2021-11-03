package top.jionjion.core.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Jion
 */

@SpringBootTest
@SpringBootApplication(scanBasePackages = "top.jionjion.di")
public class AppControllerTest {

    @Autowired(required = false)
    private AppController appController;

    @Test
    public void testSave(){
        appController.save();
    }
}