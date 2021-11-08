package top.jionjion.core.conditional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Jion
 */
@SpringBootTest
class WebApplicationPropertiesTest implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /** 测试, 是否条件注入 */
    @Test
    public void test(){
        WebApplicationProperties bean = applicationContext.getBean(WebApplicationProperties.class);
        System.out.println(bean);
        assertNotNull(bean);
    }
}