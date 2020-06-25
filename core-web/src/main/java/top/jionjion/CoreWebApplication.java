package top.jionjion;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import top.jionjion.initializer.WebAppInitializerSecond;
import top.jionjion.listener.WebApplicationListenerSecond;

import java.util.Collections;

/**
 * @author Jion
 *  启动类
 */
@SpringBootApplication
@MapperScan(basePackages = "top.jionjion.mapper")
public class CoreWebApplication
{

    public static void main(String[] args) {
        // 正常启动
//        SpringApplication.run(CoreWebApplication.class, args);

        // 自定义容器的初始化器,并调用run方法
        SpringApplication springApplication = new SpringApplication(CoreWebApplication.class);
        // 启动器
        springApplication.setInitializers(Collections.singleton(new WebAppInitializerSecond()));
        // 监听器
        springApplication.addListeners(new WebApplicationListenerSecond());
        springApplication.run(args);
    }

}
