package top.jionjion.jsr303;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 *
 * @author jion
 */
public class NullValidation {

    /**
     * @Null 必须为 null
     */
    @Null(message = "必须为 null")
    public Object mustNull;

    /**
     * @NotNull 必须不为 null
     */
    @NotNull(message = "必须不为 null")
    public Object mustNotNull;

    /**
     * @NotBlank 不能为空串
     */
    @NotBlank(message = "不能为空串")
    public String mustNotBlank;

    /**
     * @NotEmpty 集合, 数组, 字符不能为空
     */
    @NotEmpty(message = "集合, 数组, 字符不能为空")
    public String[] mustNotEmpty;

}
