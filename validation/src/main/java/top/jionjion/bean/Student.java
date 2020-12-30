package top.jionjion.bean;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 验证类
 * JSR-303 包含的注解.
 * {@code javax.validation.constraints.*}
 *
 * @author Jion
 */
@Data
public class Student {

    /*
     *      @Null 必须为 null
     *      @NonNull 必须不为 null
     *      @NotBlank 不能为空串
     *      @NotEmpty 集合,数组,字符不能为空
     *      @AssertTrue 必须为 true
     *      @AssertFalse 必须为 false
     *      @Min(value) 必须是一个值，并且不能小于指定的值
     *      @Max(value) 必须是一个值，并且不能大于指定的值
     *      @DecimalMin(value) 必须是一个数字，并且不能小于指定的值
     *      @DecimalMax(value) 必须是一个数字，并且不能大于指定的值
     *      @Digits(integer,fraction) 必须是一个数字，其值必须在指定范围内
     *      @Size(max=,min=) 的大小必须在指定范围内
     *      @Negative 必须为负数
     *      @NegativeOrZero 必须为负数或者零
     *      @Positive 正数
     *      @PositiveOrZero 正数或者零
     *      @Past 必须是一个过去的日期
     *      @PastOrPresent d必须是当前日期或过去的日期
     *      @Future 必须是一个将来的日期
     *      @FutureOrPresent 必须是当前日期或将来的日期
     *      @Email 必须为邮箱
     *      @Pattern(regex=,flag=) 必须符合指定的正则表达式
     */

    /**
     * id
     */
    @NotNull(message = "ID不能为空")
    private Long id;

    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空")
    private String name;
}
