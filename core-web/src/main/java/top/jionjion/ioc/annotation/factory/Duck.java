package top.jionjion.ioc.annotation.factory;

/**
 * @author Jion
 * @see DuckImportBeanDefinitionRegistrar
 */
public class Duck extends Animal {

    @Override
    String getName() {
        return "我是鸭子... ";
    }
}
