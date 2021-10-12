package top.jionjion.ioc.annotation.factory;

/**
 * @author Jion
 * @see MonkeyBeanDefinitionRegistryPostProcessor
 */
public class Monkey extends AbstractAnimal {

    @Override
    String getName() {
        return "我是猴子... ";
    }
}
