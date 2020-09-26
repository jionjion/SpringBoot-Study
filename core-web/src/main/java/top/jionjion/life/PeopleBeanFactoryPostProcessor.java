package top.jionjion.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 *  Bean 工厂, 对已经初始化后的Bean进行一些修改
 *  实例化时调用 BeanFactoryPostProcessor 接口
 * @author Jion
 */
@Component
public class PeopleBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // 获得 Bean的定义
        BeanDefinition people = beanFactory.getBeanDefinition("people");
        // 获得属性,并修改
        MutablePropertyValues propertyValues = people.getPropertyValues();
        propertyValues.addPropertyValue("name","Jion");
    }
}
