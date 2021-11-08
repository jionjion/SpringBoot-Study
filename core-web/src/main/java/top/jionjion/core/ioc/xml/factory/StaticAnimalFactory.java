package top.jionjion.core.ioc.xml.factory;

/**
 *  获取动物的静态工厂类
 * @author Jion
 */
public class StaticAnimalFactory {

    private final static String BEAN_NAME_CAT = "cat";

    public static AbstractAnimal getAnimal(String type){
        // 工厂方法.
        if(BEAN_NAME_CAT.equalsIgnoreCase(type)){
            return new Cat();
        }
        return null;
    }
}
