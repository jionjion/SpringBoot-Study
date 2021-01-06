package top.jionjion.jsr303.datetime;

import javax.validation.constraints.Future;

/**
 * 日期校验
 * .@Future 必须是一个将来的日期
 *
 * @author JionJion
 */
public class FutureValidation {

    /**
     * .@Future 必须是一个将来的日期
     */
    @Future(message = "必须是一个将来的日期")
    public Object mustFuture;
}
