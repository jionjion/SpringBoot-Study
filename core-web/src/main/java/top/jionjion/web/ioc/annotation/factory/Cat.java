package top.jionjion.web.ioc.annotation.factory;

/**
 * @author Jion
 * @see CatFactoryBean
 */
public class Cat extends AbstractAnimal {

    @Override
    String getName() {
        return "我是猫... ";
    }
}
