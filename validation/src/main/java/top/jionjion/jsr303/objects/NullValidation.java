package top.jionjion.jsr303.objects;

import javax.validation.constraints.Null;

/**
 * 通用对象校验
 *
 * @author jion
 */
public class NullValidation {

    /**
     * .@Null 必须为 null
     */
    @Null(message = "必须为 null")
    public Object mustNull;
}
