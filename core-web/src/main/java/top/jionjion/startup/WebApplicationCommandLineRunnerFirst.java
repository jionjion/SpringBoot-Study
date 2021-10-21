package top.jionjion.startup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *  自定义容器启动器,在容器启动后执行
 *      Order 注解 为启动器进行排序
 * @author Jion
 */
@Order(1)
@Component
public class WebApplicationCommandLineRunnerFirst implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println("--- 方法一 ---");
        System.out.println("启动加载器: 容器启动成功...");
        System.out.println("------");
    }
}
