package top.jionjion.core.ioc.annotation.factory;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * 使用 ImportBeanDefinitionRegistrar 注入Bean.
 * 常用配置 @Import 注解, 在自定义注解中,将当注解注入.同时携带自定义注解中的元信息, 用来向容器中动态添加Bean
 * {@code E:/Maven/Repository/org/springframework/spring-context/5.3.1/spring-context-5.3.1-sources.jar!/org/springframework/context/annotation/ConfigurationClassParser.java:586}
 *
 * @author Jion
 * @see org.springframework.context.annotation.ConfigurationClassParser#processImports 处理导入逻辑
 * @see DuckImportBeanDefinitionRegistrarTest 测试类
 */
@Component
public class DuckImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * 向容器注入Bean的定义
     * GenericBeanDefinition为常用的Bean定义
     */
    @Override
    public void registerBeanDefinitions(@NonNull AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // importingClassMetadata 在 @Import 注解上的类的注解信息.

        // 注入Bean
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(Duck.class);
        // 注入Bean名和定义
        registry.registerBeanDefinition("duck", genericBeanDefinition);
    }
}
