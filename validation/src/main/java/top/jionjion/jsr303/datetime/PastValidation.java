package top.jionjion.jsr303.datetime;

import javax.validation.constraints.Past;

/**
 * 日期校验
 * .@Past 必须是一个过去的日期
 *
 * @author JionJion
 */
public class PastValidation {

    /**
     * .@Past 必须是一个过去的日期
     */
    @Past(message = "必须为过去的时间")
    public Object mustPast;
}
