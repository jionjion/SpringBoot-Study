package top.jionjion.web.ioc.xml.factory;

/**
 *  获取动物的实例工厂类
 * @author Jion
 */
public class InstanceAnimalFactory {

    private final static String BEAN_NAME_CAT = "cat";

    public AbstractAnimal getAnimal(String type){
        // 工厂方法.
        if(BEAN_NAME_CAT.equalsIgnoreCase(type)){
            return new Cat();
        }
        return null;
    }
}
