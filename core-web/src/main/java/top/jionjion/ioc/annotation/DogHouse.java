package top.jionjion.ioc.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 *  引用
 * @author Jion
 */
@Component
public class DogHouse {

    /** 引用 */
    private Dog dog;

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
