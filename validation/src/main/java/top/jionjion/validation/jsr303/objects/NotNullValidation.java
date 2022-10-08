package top.jionjion.validation.jsr303.objects;

import javax.validation.constraints.NotNull;

/**
 * 通用对象校验
 * .@NotNull 必须不为 null
 *
 * @author jion
 */
@SuppressWarnings("unused")
public class NotNullValidation {

    /**
     * .@NotNull 必须不为 null
     */
    @NotNull(message = "必须不为 null")
    public Object mustNotNull;
}
