package top.jionjion.ioc.annotation.factory;

/**
 * 抽象父类,具有不同子类实现,分别实现不同的接口完成依赖注入
 *
 * @author Jion
 */
public abstract class Animal {

    /**
     * 获得动物名称
     *
     * @return 名称
     */
    abstract String getName();
}
