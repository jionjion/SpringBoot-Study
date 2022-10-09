package top.jionjion.core.ioc.annotation.factory;

/**
 * @author Jion
 * @see CatFactoryBean
 */
@SuppressWarnings("unused")
public class Cat extends AbstractAnimal {

    @Override
    String getName() {
        return "我是猫... ";
    }
}
