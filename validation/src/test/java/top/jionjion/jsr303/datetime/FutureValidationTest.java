package top.jionjion.jsr303.datetime;

import org.junit.jupiter.api.Test;
import top.jionjion.ValidationBaseTest;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

class FutureValidationTest extends ValidationBaseTest {


    @Test
    public void test() {
        FutureValidation obj = new FutureValidation();
        // java.util.Date 日期 + 时间 + 时区
        obj.dateMustFuture = new Date(System.currentTimeMillis() - 10000);
        // java.util.Calendar 日期
        obj.calendarMustFuture = Calendar.getInstance();
        obj.calendarMustFuture.set(2020, 1, 1);

        // java.time.Instant 精确时间点， 日期 + 时间 + 时区
        obj.instantMustFuture = Instant.now().minus(1, ChronoUnit.DAYS);
        // java.time.ZonedDateTime 日期 + 时间 + 时区
        obj.zonedDateTimeMustFuture = ZonedDateTime.of(2020, 1, 1, 0, 0, 0, 0, ZoneId.systemDefault());
        // java.time.LocalDateTime  日期 + 时间
        obj.localDateTimeMustFuture = LocalDateTime.MIN;
        // java.time.LocalDate 日期
        obj.localDateMustFuture = LocalDate.of(2020, 1, 1);
        // java.time.LocalTime 时间
        obj.localTimeMustFuture = LocalTime.MIN;
        // java.time.OffsetDateTime 日期 + 时间 + 时区
        obj.offsetDateTimeMustFuture = OffsetDateTime.MIN;
        // java.time.OffsetTime 时间 + 时区
        obj.offsetTimeMustFuture = OffsetTime.MIN;

        // java.time.Year 第N年
        obj.yearMustFuture = Year.of(2020);
        // java.time.YearMonth 当年第N月
        obj.yearMonthMustFuture = YearMonth.of(2020, 1);
        // java.time.MonthDay 当月第N天
        obj.monthDayMustFuture = MonthDay.of(1, 1);

        // 必须是一个将来的日期 fail
        super.validate(obj);
    }
}