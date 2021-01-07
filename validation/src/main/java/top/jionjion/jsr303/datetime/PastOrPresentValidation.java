package top.jionjion.jsr303.datetime;

import javax.validation.constraints.PastOrPresent;
import java.time.*;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期校验
 * .@PastOrPresentOrPresent 必须是当前日期或过去的日期
 *
 * @author JionJion
 */
public class PastOrPresentValidation {

    /**
     * java.util.Date 日期 + 时间 + 时区
     */
    @PastOrPresent(message = "Date必须是当前日期或过去的日期")
    public Date dateMustPastOrPresent;

    /**
     * java.util.Calendar 日期
     */
    @PastOrPresent(message = "Calendar必须是当前日期或过去的日期")
    public Calendar calendarMustPastOrPresent;

    /**
     * java.time.Instant 精确时间点， 日期 + 时间 + 时区
     */
    @PastOrPresent(message = "Instant必须是当前日期或过去的日期")
    public Instant instantMustPastOrPresent;

    /**
     * java.time.ZonedDateTime 日期 + 时间 + 时区
     */
    @PastOrPresent(message = "ZonedDateTime必须是当前日期或过去的日期")
    public ZonedDateTime zonedDateTimeMustPastOrPresent;

    /**
     * java.time.LocalDateTime  日期 + 时间
     */
    @PastOrPresent(message = "LocalDateTime必须是当前日期或过去的日期")
    public LocalDateTime localDateTimeMustPastOrPresent;

    /**
     * java.time.LocalDate 日期
     */
    @PastOrPresent(message = "LocalDate必须是当前日期或过去的日期")
    public LocalDate localDateMustPastOrPresent;

    /**
     * java.time.LocalTime 时间
     */
    @PastOrPresent(message = "LocalTime必须是当前日期或过去的日期")
    public LocalTime localTimeMustPastOrPresent;

    /**
     * java.time.OffsetDateTime 日期 + 时间 + 时区
     */
    @PastOrPresent(message = "OffsetDateTime必须是当前日期或过去的日期")
    public OffsetDateTime offsetDateTimeMustPastOrPresent;

    /**
     * java.time.OffsetTime 时间 + 时区
     */
    @PastOrPresent(message = "OffsetTime必须是当前日期或过去的日期")
    public OffsetTime offsetTimeMustPastOrPresent;

    /**
     * java.time.Year 第N年
     */
    @PastOrPresent(message = "Year必须是当前日期或过去的日期")
    public Year yearMustPastOrPresent;

    /**
     * java.time.YearMonth 当年第N月
     */
    @PastOrPresent(message = "YearMonth必须是当前日期或过去的日期")
    public YearMonth yearMonthMustPastOrPresent;

    /**
     * java.time.MonthDay 当月第N天
     */
    @PastOrPresent(message = "MonthDay必须是当前日期或过去的日期")
    public MonthDay monthDayMustPastOrPresent;
}
