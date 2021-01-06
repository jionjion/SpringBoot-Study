package top.jionjion.jsr303.objects;

import javax.validation.constraints.NotNull;

/**
 * 通用对象校验
 *
 * @author jion
 */
public class NotNullValidation {

    /**
     * .@NotNull 必须不为 null
     */
    @NotNull(message = "必须不为 null")
    public Object mustNotNull;
}
