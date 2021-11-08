package top.jionjion.validation.jsr303.datetime;

import javax.validation.constraints.Future;
import java.time.*;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期校验
 * .@Future 必须是一个将来的日期
 *
 * @author JionJion
 */
public class FutureValidation {

    /**
     * java.util.Date 日期 + 时间 + 时区
     */
    @Future(message = "Date必须是一个将来的日期")
    public Date dateMustFuture;

    /**
     * java.util.Calendar 日期
     */
    @Future(message = "Calendar必须是一个将来的日期")
    public Calendar calendarMustFuture;

    /**
     * java.time.Instant 精确时间点， 日期 + 时间 + 时区
     */
    @Future(message = "Instant必须是一个将来的日期")
    public Instant instantMustFuture;

    /**
     * java.time.ZonedDateTime 日期 + 时间 + 时区
     */
    @Future(message = "ZonedDateTime必须是一个将来的日期")
    public ZonedDateTime zonedDateTimeMustFuture;

    /**
     * java.time.LocalDateTime  日期 + 时间
     */
    @Future(message = "LocalDateTime必须是一个将来的日期")
    public LocalDateTime localDateTimeMustFuture;

    /**
     * java.time.LocalDate 日期
     */
    @Future(message = "LocalDate必须是一个将来的日期")
    public LocalDate localDateMustFuture;

    /**
     * java.time.LocalTime 时间
     */
    @Future(message = "LocalTime必须是一个将来的日期")
    public LocalTime localTimeMustFuture;

    /**
     * java.time.OffsetDateTime 日期 + 时间 + 时区
     */
    @Future(message = "OffsetDateTime必须是一个将来的日期")
    public OffsetDateTime offsetDateTimeMustFuture;

    /**
     * java.time.OffsetTime 时间 + 时区
     */
    @Future(message = "OffsetTime必须是一个将来的日期")
    public OffsetTime offsetTimeMustFuture;

    /**
     * java.time.Year 第N年
     */
    @Future(message = "Year必须是一个将来的日期")
    public Year yearMustFuture;

    /**
     * java.time.YearMonth 当年第N月
     */
    @Future(message = "YearMonth必须是一个将来的日期")
    public YearMonth yearMonthMustFuture;

    /**
     * java.time.MonthDay 当月第N天
     */
    @Future(message = "MonthDay必须是一个将来的日期")
    public MonthDay monthDayMustFuture;
}
