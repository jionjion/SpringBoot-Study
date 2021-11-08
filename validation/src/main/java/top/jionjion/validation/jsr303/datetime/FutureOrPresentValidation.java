package top.jionjion.validation.jsr303.datetime;

import javax.validation.constraints.FutureOrPresent;
import java.time.*;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期校验
 * .@FutureOrPresentOrPresent 必须是当前日期或将来的日期
 *
 * @author JionJion
 */
public class FutureOrPresentValidation {

    /**
     * java.util.Date 日期 + 时间 + 时区
     */
    @FutureOrPresent(message = "Date必须是当前日期或将来的日期")
    public Date dateMustFutureOrPresent;

    /**
     * java.util.Calendar 日期
     */
    @FutureOrPresent(message = "Calendar必须是当前日期或将来的日期")
    public Calendar calendarMustFutureOrPresent;

    /**
     * java.time.Instant 精确时间点， 日期 + 时间 + 时区
     */
    @FutureOrPresent(message = "Instant必须是当前日期或将来的日期")
    public Instant instantMustFutureOrPresent;

    /**
     * java.time.ZonedDateTime 日期 + 时间 + 时区
     */
    @FutureOrPresent(message = "ZonedDateTime必须是当前日期或将来的日期")
    public ZonedDateTime zonedDateTimeMustFutureOrPresent;

    /**
     * java.time.LocalDateTime  日期 + 时间
     */
    @FutureOrPresent(message = "LocalDateTime必须是当前日期或将来的日期")
    public LocalDateTime localDateTimeMustFutureOrPresent;

    /**
     * java.time.LocalDate 日期
     */
    @FutureOrPresent(message = "LocalDate必须是当前日期或将来的日期")
    public LocalDate localDateMustFutureOrPresent;

    /**
     * java.time.LocalTime 时间
     */
    @FutureOrPresent(message = "LocalTime必须是当前日期或将来的日期")
    public LocalTime localTimeMustFutureOrPresent;

    /**
     * java.time.OffsetDateTime 日期 + 时间 + 时区
     */
    @FutureOrPresent(message = "OffsetDateTime必须是当前日期或将来的日期")
    public OffsetDateTime offsetDateTimeMustFutureOrPresent;

    /**
     * java.time.OffsetTime 时间 + 时区
     */
    @FutureOrPresent(message = "OffsetTime必须是当前日期或将来的日期")
    public OffsetTime offsetTimeMustFutureOrPresent;

    /**
     * java.time.Year 第N年
     */
    @FutureOrPresent(message = "Year必须是当前日期或将来的日期")
    public Year yearMustFutureOrPresent;

    /**
     * java.time.YearMonth 当年第N月
     */
    @FutureOrPresent(message = "YearMonth必须是当前日期或将来的日期")
    public YearMonth yearMonthMustFutureOrPresent;

    /**
     * java.time.MonthDay 当月第N天
     */
    @FutureOrPresent(message = "MonthDay必须是当前日期或将来的日期")
    public MonthDay monthDayMustFutureOrPresent;
}
