package top.jionjion.validation.jsr303.objects;

import javax.validation.constraints.NotEmpty;
import java.util.Collection;

/**
 * 通用对象校验
 *  .@NotEmpty 集合, 数组, 字符不能为空
 *
 * @author jion
 */
public class NotEmptyValidation {

    /**
     * .@NotEmpty 集合, 数组, 字符不能为空
     */
    @NotEmpty(message = "集合不能为空")
    public Collection<?> collectionMustNotEmpty;

    @NotEmpty(message = "数组不能为空")
    public Object[] arrayMustNotEmpty;

    @NotEmpty(message = "字符不能为空")
    public String mustStringNotEmpty;
}
