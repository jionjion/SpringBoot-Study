package top.jionjion.core.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 自定义容器启动器.通过 META-INF/spring.factories 注册
 * 在容器注入时,进行操作
 *
 * @author Jion
 */
@Order(1)
public class WebApplicationInitializerFirst implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        // 获得容器中环境变量
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        System.out.println("--- 方法一 ---");
        System.out.println("监听器: 容器初始化器启动..." + environment.hashCode());
        System.out.println("------");
    }
}
