package top.jionjion.ioc.xml.factory;

/**
 *  获取动物的静态工厂类
 * @author Jion
 */
public class StaticAnimalFactory {
    public static Animal getAnimal(String type){
        // 工厂方法.
        if("cat".equalsIgnoreCase(type)){
            return new Cat();
        }
        return null;
    }
}
