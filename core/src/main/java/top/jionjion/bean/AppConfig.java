package top.jionjion.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 *  @author Jion
 *      自定义Bean的配置Bean
 *      注解二选一均可
 */
@Configuration
@Component
public class AppConfig {

    @Bean(name = {"user","USER"}, initMethod = "init", destroyMethod = "destroy")
    public User getUser(){
        return new User();
    }
}
