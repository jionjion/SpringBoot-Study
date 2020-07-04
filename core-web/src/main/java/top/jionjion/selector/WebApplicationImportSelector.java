package top.jionjion.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 *  自定义导入
 * @author Jion
 */
public class WebApplicationImportSelector implements ImportSelector {


    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("ImportSelector: 自定义导入类...");
        return new String[] {"top.jionjion.bean.Student"};
    }
}
