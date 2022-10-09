package top.jionjion.core.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * 在具体Bean实例化时,调用 BeanPostProcessor 接口,动态修改赋值
 *
 * @author Jion
 * @see People
 */
@Component
@SuppressWarnings("unused")
public class PeopleBeanPostProcessor implements BeanPostProcessor {

    private static final String BEAN_NAME_PEOPLE = "people";

    @Override
    public Object postProcessBeforeInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        // 在类初始化前调用, 若有返回值,则将该返回值作为实例化结果
        if (BEAN_NAME_PEOPLE.equals(beanName)) {
            return new People();
        }
        // 返回为 null, 继续初始化
        return null;
    }

    @SuppressWarnings("SameReturnValue")
    @Override
    public Object postProcessAfterInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        // 在类实例化后调用.
        if (BEAN_NAME_PEOPLE.equals(beanName)) {
            // 名称一致, 实例化, 修改属性
            People people = (People) bean;
            people.setName("Aires");
        }
        // 返回当前 Bean 实例, 继续执行
        return bean;
    }
}
