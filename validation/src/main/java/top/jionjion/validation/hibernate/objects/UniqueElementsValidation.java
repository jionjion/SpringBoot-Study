package top.jionjion.validation.hibernate.objects;

import org.hibernate.validator.constraints.UniqueElements;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * 通用对象校验
 * .@UniqueElements 集合必须没有重复
 *
 * @author jion
 */
public class UniqueElementsValidation {

    /**
     *  .@UniqueElements 集合必须没有重复
     */
    @UniqueElements(message="Collection集合必须没有重复")
    public Collection<String> mustCollectionUniqueElements;

    @UniqueElements(message="List集合必须没有重复")
    public List<String> mustListUniqueElements;

    @UniqueElements(message="Set集合必须没有重复")
    public Set<String> mustSetUniqueElements;
}
