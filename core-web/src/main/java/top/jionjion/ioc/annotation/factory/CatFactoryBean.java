package top.jionjion.ioc.annotation.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * 使用 FactoryBean<T> 注入Bean, 通过实例工厂注入容器
 *
 * @author Jion
 */
@Component("cat")
public class CatFactoryBean implements FactoryBean<Animal> {

    @Override
    public Animal getObject() throws Exception {
        return new Cat();
    }

    @Override
    public Class<?> getObjectType() {
        return Animal.class;
    }
}
