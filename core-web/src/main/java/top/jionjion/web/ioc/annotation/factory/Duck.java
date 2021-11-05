package top.jionjion.web.ioc.annotation.factory;

/**
 * @author Jion
 * @see DuckImportBeanDefinitionRegistrar
 */
public class Duck extends AbstractAnimal {

    @Override
    String getName() {
        return "我是鸭子... ";
    }
}
