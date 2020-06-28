package top.jionjion.startup;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *  自定义容器启动器,在容器启动后执行
 *      优先执行
 * @author Jion
 */
@Order(1)
@Component
public class WebApplicationCommandLineRunnerSecond implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("--- 方法二 ---");
        System.out.println("启动加载器: 容器启动成功...");
        System.out.println("------");
    }
}
