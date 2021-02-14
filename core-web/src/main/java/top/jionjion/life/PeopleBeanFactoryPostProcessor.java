package top.jionjion.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * Bean工厂后置处理器
 * 对已经加载到容器中的BeanDefinition信息进行修改,从而实现最终实例化时的属性替换
 *
 * @author Jion
 * @see People
 */
@Component
public class PeopleBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // 获得 Bean的定义
        BeanDefinition people = beanFactory.getBeanDefinition("people");
        // 获得属性,并修改
        MutablePropertyValues propertyValues = people.getPropertyValues();
        propertyValues.addPropertyValue("name", "Jion");
    }
}
