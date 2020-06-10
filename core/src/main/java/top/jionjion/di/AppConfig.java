package top.jionjion.di;

import org.springframework.stereotype.Component;

/**
 *  @author Jion
 *      组件
 */
@Component
public class AppConfig {

    public AppConfig() {    }

    public void save(){
        System.out.println("Component 保存了...");
    }
}
