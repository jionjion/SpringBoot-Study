package top.jionjion.core.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  @author Jion
 *      自定义Bean的配置Bean
 *      注解二选一均可
 */
@Configuration
public class AppConfig {

    @Bean(name = {"user","USER"}, initMethod = "init", destroyMethod = "destroy")
    public User getUser(){
        return new User();
    }
}
