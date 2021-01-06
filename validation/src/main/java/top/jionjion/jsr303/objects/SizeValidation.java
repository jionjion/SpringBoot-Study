package top.jionjion.jsr303.objects;

import javax.validation.constraints.Size;

/**
 * 通用对象校验
 *
 * @author jion
 */
public class SizeValidation {

    /**
     * .@Size(max,min) 字符串长度, 集合, 数组必须在指定范围内
     */
    @Size(min = 1, max = 10, message = "成员数量必须在1到10之间")
    public Object limitSize;
}
