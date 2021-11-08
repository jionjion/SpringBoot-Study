package top.jionjion.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.jionjion.core.initializer.WebApplicationInitializerSecond;
import top.jionjion.core.listener.WebApplicationListenerSecond;

import java.util.Properties;

/**
 * 启动类
 * <p>
 * 使用 @ImportResource(locations = "classpath:ioc/xml/bean-config.xml")  引入xml配置文件
 * 使用 @Import({WebApplicationImportSelector.class, WebApplicationDeferredImportSelector.java}) 引入配置类.查询注入类
 *
 * @author Jion
 */
@SpringBootApplication
public class CoreWebApplication {

    public static void main(String[] args) {
        // 自定义容器的初始化器,并调用run方法
        SpringApplication springApplication = new SpringApplication(CoreWebApplication.class);
        // 启动器
        springApplication.addInitializers(new WebApplicationInitializerSecond());
        // 监听器
        springApplication.addListeners(new WebApplicationListenerSecond());
        // 设置默认
        Properties properties = new Properties();
        properties.setProperty("author", "Jion17");
        springApplication.setDefaultProperties(properties);
        // run 方法
        springApplication.run(args);
    }
}