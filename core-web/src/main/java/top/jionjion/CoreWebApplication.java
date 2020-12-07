package top.jionjion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import top.jionjion.initializer.WebApplicationInitializerSecond;
import top.jionjion.listener.WebApplicationListenerSecond;
import top.jionjion.selector.WebApplicationDeferredImportSelector;
import top.jionjion.selector.WebApplicationImportSelector;

import java.util.Collections;
import java.util.Properties;

/**
 * @author Jion
 *  启动类
 */
//@Import({WebApplicationImportSelector.class, WebApplicationDeferredImportSelector.class})
//@ImportResource(locations = "classpath:ioc/xml/bean-config.xml")
@SpringBootApplication
public class CoreWebApplication {

    public static void main(String[] args) {
        // 正常启动
//        SpringApplication.run(CoreWebApplication.class, args);

        // 自定义容器的初始化器,并调用run方法
        SpringApplication springApplication = new SpringApplication(CoreWebApplication.class);
        // 启动器
        springApplication.addInitializers(new WebApplicationInitializerSecond());
        // 监听器
        springApplication.addListeners(new WebApplicationListenerSecond());
        // 设置默认
        Properties properties = new Properties();
        properties.setProperty("author","Jion17");
        springApplication.setDefaultProperties(properties);
        // run 方法
        springApplication.run(args);
    }
}