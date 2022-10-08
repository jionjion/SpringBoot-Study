package top.jionjion.core.ioc.annotation.factory;

/**
 * @author Jion
 * @see DuckImportBeanDefinitionRegistrar
 */
@SuppressWarnings("unused")
public class Duck extends AbstractAnimal {


    @Override
    String getName() {
        return "我是鸭子... ";
    }
}
