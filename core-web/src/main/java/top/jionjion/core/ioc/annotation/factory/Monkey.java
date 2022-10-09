package top.jionjion.core.ioc.annotation.factory;

/**
 * @author Jion
 * @see MonkeyBeanDefinitionRegistryPostProcessor
 */
public class Monkey extends AbstractAnimal {

    @Override
    @SuppressWarnings("unused")
    String getName() {
        return "我是猴子... ";
    }
}
