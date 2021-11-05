package top.jionjion.web.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 *  对自定义 aware 接口进行后置处理
 * @author Jion
 */
@Component
public class WebApplicationAwareProcessor implements BeanPostProcessor {

    /** 上下文容器 */
    private final ConfigurableApplicationContext context;

    public WebApplicationAwareProcessor(ConfigurableApplicationContext context) {
        this.context = context;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Aware){
            if(bean instanceof WebApplicationAware){
                // 从上下文容器中获得, 并封装为 自定义对象
                WebApplicationFlag flag = context.getBean(WebApplicationFlag.class);
                String property = context.getEnvironment().getProperty("web-application");
                flag.setWebApplicationFlag(Boolean.parseBoolean(property));
                // 调用接口实现的方法
                ((WebApplicationAware) bean).setWebApplicationFlag(flag);
            }
        }
        // 一定要返回 Bean
        return bean;
    }
}
