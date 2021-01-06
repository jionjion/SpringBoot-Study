package top.jionjion.jsr303.datetime;

import javax.validation.constraints.PastOrPresent;

/**
 * 日期校验
 *
 * @author JionJion
 */
public class PastOrPresentValidation {

    /**
     * .@PastOrPresent 必须是当前日期或过去的日期
     */
    @PastOrPresent(message = "必须是当前日期或过去的日期")
    public Object mustPastOrPresent;
}
