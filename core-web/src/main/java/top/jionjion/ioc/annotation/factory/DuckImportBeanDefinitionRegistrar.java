package top.jionjion.ioc.annotation.factory;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 *  使用 ImportBeanDefinitionRegistrar 注入Bean
 * @author Jion
 */
@Component
public class DuckImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 注入Bean
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
        rootBeanDefinition.setBeanClass(Duck.class);
        // 注入Bean名和定义
        registry.registerBeanDefinition("duck", rootBeanDefinition);
    }
}
