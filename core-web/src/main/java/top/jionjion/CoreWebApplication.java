package top.jionjion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.jionjion.initializer.WebApplicationInitializerSecond;
import top.jionjion.listener.WebApplicationListenerSecond;

import java.util.Collections;

/**
 * @author Jion
 *  启动类
 */
@SpringBootApplication
public class CoreWebApplication {

    public static void main(String[] args) {
        // 正常启动
//        SpringApplication.run(CoreWebApplication.class, args);

        // 自定义容器的初始化器,并调用run方法
        SpringApplication springApplication = new SpringApplication(CoreWebApplication.class);
        // 启动器
        springApplication.setInitializers(Collections.singleton(new WebApplicationInitializerSecond()));
        // 监听器
        springApplication.addListeners(new WebApplicationListenerSecond());
        springApplication.run(args);
    }

}
