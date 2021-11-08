package top.jionjion.core.ioc.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注解配置文件
 *
 * @author Jion
 */
@Configuration
public class BeanConfig {

    @Bean(name = {"dog", "DOG"}, initMethod = "init", destroyMethod = "destroy")
    public Dog dog() {
        return new Dog();
    }
}
