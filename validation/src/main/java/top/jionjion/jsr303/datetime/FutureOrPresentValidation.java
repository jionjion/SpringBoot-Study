package top.jionjion.jsr303.datetime;

import javax.validation.constraints.FutureOrPresent;

/**
 * 日期校验
 * .@FutureOrPresent 必须是当前日期或将来的日期
 *
 * @author JionJion
 */
public class FutureOrPresentValidation {
    /**
     * .@FutureOrPresent 必须是当前日期或将来的日期
     */
    @FutureOrPresent(message = "必须是当前日期或将来的日期")
    public Object mustFutureOrPresent;
}
