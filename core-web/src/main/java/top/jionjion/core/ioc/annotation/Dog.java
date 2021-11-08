package top.jionjion.core.ioc.annotation;

/**
 * @author Jion
 */
public class Dog {

    public void init(){
        System.out.println("Bean 初始化...");
    }

    public void destroy(){
        System.out.println("Bean 被销毁...");
    }
}
