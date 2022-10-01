package top.jionjion.core.selector;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.lang.NonNull;

/**
 * 自定义导入, 通过实现 ImportSelector 接口, 将需要导入容器的类的全路径数组进行返回, 容器会加载并注入
 * 该接口可以配合 Conditional 接口实现条件注入
 *
 * @author Jion
 */
public class WebApplicationDeferredImportSelector implements DeferredImportSelector {


    @Override
    public String[] selectImports(@NonNull AnnotationMetadata importingClassMetadata) {
        System.out.println("DeferredImportSelector: 自定义导入类...");
        return new String[]{"top.jionjion.bean.Student"};
    }
}
