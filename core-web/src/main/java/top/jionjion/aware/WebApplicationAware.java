package top.jionjion.aware;

import org.springframework.beans.factory.Aware;

/**
 *  自定义的 Aware 接口, 用来 从容器中获得类
 * @see WebApplicationAwareProcessor 设置过程
 * @see WebApplicationFlag 设置对象
 * @author Jion
 */
public interface WebApplicationAware extends Aware {

    /** 自定义, 将当容器对象设置到实现方法中 */
    void setWebApplicationFlag(WebApplicationFlag webApplicationFlag);
}
