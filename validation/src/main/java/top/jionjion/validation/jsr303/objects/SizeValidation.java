package top.jionjion.validation.jsr303.objects;

import javax.validation.constraints.Size;
import java.util.Collection;

/**
 * 通用对象校验
 * .@Size(max,min) 字符串长度, 集合, 数组必须在指定范围内
 * 如果对象为null，不触发校验
 *
 * @author jion
 */
public class SizeValidation {

    /**
     * .@Size(max,min) 集合必须在指定范围内
     */
    @Size(min = 1, max = 10, message = "集合成员数量必须在1到10之间")
    public Collection<?> collectionLimitSize;

    /**
     * .@Size(max,min) 数组必须在指定范围内
     */
    @Size(min = 1, max = 10, message = "数组成员数量必须在1到10之间")
    public Object[] arrayLimitSize;

    /**
     * .@Size(max,min) 字符串长度必须在指定范围内
     */
    @Size(min = 1, max = 10, message = "字符串成员数量必须在1到10之间")
    public String stringLimitSize;
}
