package top.jionjion.ioc.annotation.factory;

/**
 * @author Jion
 * @see CatFactoryBean
 */
public class Cat extends Animal {

    @Override
    String getName() {
        return "我是猫... ";
    }
}
