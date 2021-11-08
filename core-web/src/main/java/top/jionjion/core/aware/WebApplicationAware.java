package top.jionjion.core.aware;

import org.springframework.beans.factory.Aware;

/**
 * 自定义的 Aware 接口, 用来 从容器中获得类
 *
 * @author Jion
 * @see WebApplicationAwareProcessor 设置过程
 * @see WebApplicationFlag 设置对象
 */
public interface WebApplicationAware extends Aware {

    /**
     * 自定义, 将当容器对象设置到实现方法中
     *
     * @param webApplicationFlag 当前接口实现类中的属性,在Spring处理时,对其赋值..
     */
    void setWebApplicationFlag(WebApplicationFlag webApplicationFlag);
}
