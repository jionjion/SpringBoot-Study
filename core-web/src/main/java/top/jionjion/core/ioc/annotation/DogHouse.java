package top.jionjion.core.ioc.annotation;

import org.springframework.stereotype.Component;

/**
 * 使用 @Component 注解, 将该类注入容器中
 *
 * @author Jion
 */
@Component
public class DogHouse {

    /**
     * 引用
     */
    private Dog dog;

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
