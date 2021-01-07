package top.jionjion.jsr303.datetime;

import org.junit.jupiter.api.Test;
import top.jionjion.jsr303.JSR303BaseTest;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

class PastValidationTest extends JSR303BaseTest {

    @Test
    public void test() {
        PastValidation obj = new PastValidation();
        // java.util.Date 日期 + 时间 + 时区
        obj.dateMustPast = new Date(System.currentTimeMillis() + 10000);
        // java.util.Calendar 日期
        obj.calendarMustPast = Calendar.getInstance();
        obj.calendarMustPast.set(2050, 12, 1);

        // java.time.Instant 精确时间点， 日期 + 时间 + 时区
        obj.instantMustPast = Instant.now().plus(1, ChronoUnit.DAYS);
        // java.time.ZonedDateTime 日期 + 时间 + 时区
        obj.zonedDateTimeMustPast = ZonedDateTime.of(2050, 12, 30, 0, 0, 0, 0, ZoneId.systemDefault());
        // java.time.LocalDateTime  日期 + 时间
        obj.localDateTimeMustPast = LocalDateTime.MAX;
        // java.time.LocalDate 日期
        obj.localDateMustPast = LocalDate.of(2050, 12, 30);
        // java.time.LocalTime 时间
        obj.localTimeMustPast = LocalTime.MAX;
        // java.time.OffsetDateTime 日期 + 时间 + 时区
        obj.offsetDateTimeMustPast = OffsetDateTime.MAX;
        // java.time.OffsetTime 时间 + 时区
        obj.offsetTimeMustPast = OffsetTime.MAX;

        // java.time.Year 第N年
        obj.yearMustPast = Year.of(2050);
        // java.time.YearMonth 当年第N月
        obj.yearMonthMustPast = YearMonth.of(2050, 12);
        // java.time.MonthDay 当月第N天
        obj.monthDayMustPast = MonthDay.of(12, 30);

        // 必须是一个过去的日期 fail
        super.validate(obj);
    }
}