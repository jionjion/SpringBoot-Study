package top.jionjion.validation.jsr303.datetime;

import javax.validation.constraints.Past;
import java.time.*;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期校验
 * .@Past 必须是一个过去的日期
 *
 * @author JionJion
 */
@SuppressWarnings("unused")
public class PastValidation {

    /**
     * java.util.Date 日期 + 时间 + 时区
     */
    @Past(message = "Date必须为过去的时间")
    public Date dateMustPast;

    /**
     * java.util.Calendar 日期
     */
    @Past(message = "Calendar必须为过去的时间")
    public Calendar calendarMustPast;

    /**
     * java.time.Instant 精确时间点， 日期 + 时间 + 时区
     */
    @Past(message = "Instant必须为过去的时间")
    public Instant instantMustPast;

    /**
     * java.time.ZonedDateTime 日期 + 时间 + 时区
     */
    @Past(message = "ZonedDateTime必须为过去的时间")
    public ZonedDateTime zonedDateTimeMustPast;

    /**
     * java.time.LocalDateTime  日期 + 时间
     */
    @Past(message = "LocalDateTime必须为过去的时间")
    public LocalDateTime localDateTimeMustPast;

    /**
     * java.time.LocalDate 日期
     */
    @Past(message = "LocalDate必须为过去的时间")
    public LocalDate localDateMustPast;

    /**
     * java.time.LocalTime 时间
     */
    @Past(message = "LocalTime必须为过去的时间")
    public LocalTime localTimeMustPast;

    /**
     * java.time.OffsetDateTime 日期 + 时间 + 时区
     */
    @Past(message = "OffsetDateTime必须为过去的时间")
    public OffsetDateTime offsetDateTimeMustPast;

    /**
     * java.time.OffsetTime 时间 + 时区
     */
    @Past(message = "OffsetTime必须为过去的时间")
    public OffsetTime offsetTimeMustPast;

    /**
     * java.time.Year 第N年
     */
    @Past(message = "Year必须为过去的时间")
    public Year yearMustPast;

    /**
     * java.time.YearMonth 当年第N月
     */
    @Past(message = "YearMonth必须为过去的时间")
    public YearMonth yearMonthMustPast;

    /**
     * java.time.MonthDay 当月第N天
     */
    @Past(message = "MonthDay必须为过去的时间")
    public MonthDay monthDayMustPast;
}
