package top.jionjion.jsr303;

import javax.validation.constraints.*;

/**
 *
 * @author jion
 */
public class NumberValidation {

    /**
     *  @Min(value) 必须是一个值，并且不能小于指定的值
     */
    @Min(value = 0, message = "不能小于0")
    public Object limitMin;

    /**
     *   @Max(value) 必须是一个值，并且不能大于指定的值
     */
    @Max(value = 100, message = "不能大于100")
    public Object limitMax;

    
    /*
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

}
