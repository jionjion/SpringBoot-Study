package top.jionjion.selector;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 *  自定义导入
 * @author Jion
 */
public class WebApplicationDeferredImportSelector implements DeferredImportSelector {


    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("DeferredImportSelector: 自定义导入类...");
        return new String[] {"top.jionjion.bean.Student"};
    }
}
