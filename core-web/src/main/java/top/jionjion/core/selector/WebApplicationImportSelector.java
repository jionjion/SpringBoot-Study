package top.jionjion.core.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.lang.NonNull;

/**
 * 自定义导入, 通过实现 ImportSelector 接口, 将需要导入容器的类的全路径数组进行返回, 容器会加载并注入
 *
 * @author Jion
 */
@SuppressWarnings("unused")
public class WebApplicationImportSelector implements ImportSelector {

    @Override
    public @NonNull String[] selectImports(@NonNull AnnotationMetadata importingClassMetadata) {
        System.out.println("ImportSelector: 自定义导入类...");
        return new String[]{"top.jionjion.bean.Student"};
    }
}
