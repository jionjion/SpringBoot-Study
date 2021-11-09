package top.jionjion.core.ioc.annotation.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * InstantiationAwareBeanPostProcessor 接口为 BeanPostProcessor 子接口, 在每一个Bean实例化前进行调用.
 * 如果 postProcessBeforeInstantiation 方法返回不为空,则作为当前实例化Bean的实例化结果进行返回
 *
 * @author Jion
 */
@Component
public class PigInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    private final static String BEAN_NAME_PIG = "pig";

    /**
     * InstantiationAwareBeanPostProcessor 子接口方法
     * 在 Bean 实例化前进行调用, 改类的返回结果作为Bean的代理结果
     *
     * @see AbstractAutowireCapableBeanFactory#resolveBeforeInstantiation
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (BEAN_NAME_PIG.equals(beanName)) {
            try {
                // 返回代理类实例
                return Pig.class.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    /**
     * BeanPostProcessor 父接口方法
     * 在 Bean 由 postProcessBeforeInstantiation 返回不为空,代理实例化后,执行后续逻辑
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (BEAN_NAME_PIG.equals(beanName)) {
            System.out.println(((Pig) bean).getName());
        }
        return null;
    }

    /**
     * 在实例化后,更多依赖属性自动装配前, 进行调用.
     * 是否进行自定义依赖注入管理
     *
     * @see AbstractAutowireCapableBeanFactory.populateBean()
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        // 该类进行自定义依赖管理
        return !BEAN_NAME_PIG.equals(beanName);
    }

    /**
     * 在实例化后,更多依赖属性自动装配后, 进行调用.
     * 重定义一些注入的属性值,如不符合预期,进行修改
     *
     * @see AbstractAutowireCapableBeanFactory.populateBean()
     */
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        return null;
    }
}
