package top.jionjion.ioc.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  注解配置文件
 * @author Jion
 */
@Configuration
public class BeanConfig {

    @Bean
        public Dog dog(){
        return new Dog();
    }
}
