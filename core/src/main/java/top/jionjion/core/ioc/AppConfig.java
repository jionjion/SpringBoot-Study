package top.jionjion.core.ioc;

import org.springframework.stereotype.Component;

/**
 *  @author Jion
 *      组件
 */
@Component
public class AppConfig {

    public void save(){
        System.out.println("Component 保存了...");
    }
}
