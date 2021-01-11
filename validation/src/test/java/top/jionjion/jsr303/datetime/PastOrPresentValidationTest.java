package top.jionjion.jsr303.datetime;

import org.junit.jupiter.api.Test;
import top.jionjion.ValidationBaseTest;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

class PastOrPresentOrPresentValidationTest extends ValidationBaseTest {

    @Test
    public void test() {
        PastOrPresentValidation obj = new PastOrPresentValidation();
        // java.util.Date 日期 + 时间 + 时区
        obj.dateMustPastOrPresent = new Date(System.currentTimeMillis() + 10000);
        // java.util.Calendar 日期
        obj.calendarMustPastOrPresent = Calendar.getInstance();
        obj.calendarMustPastOrPresent.set(2050, 12, 1);

        // java.time.Instant 精确时间点， 日期 + 时间 + 时区
        obj.instantMustPastOrPresent = Instant.now().plus(1, ChronoUnit.DAYS);
        // java.time.ZonedDateTime 日期 + 时间 + 时区
        obj.zonedDateTimeMustPastOrPresent = ZonedDateTime.of(2050, 12, 30, 0, 0, 0, 0, ZoneId.systemDefault());
        // java.time.LocalDateTime  日期 + 时间
        obj.localDateTimeMustPastOrPresent = LocalDateTime.MAX;
        // java.time.LocalDate 日期
        obj.localDateMustPastOrPresent = LocalDate.of(2050, 12, 30);
        // java.time.LocalTime 时间
        obj.localTimeMustPastOrPresent = LocalTime.MAX;
        // java.time.OffsetDateTime 日期 + 时间 + 时区
        obj.offsetDateTimeMustPastOrPresent = OffsetDateTime.MAX;
        // java.time.OffsetTime 时间 + 时区
        obj.offsetTimeMustPastOrPresent = OffsetTime.MAX;

        // java.time.Year 第N年
        obj.yearMustPastOrPresent = Year.of(2050);
        // java.time.YearMonth 当年第N月
        obj.yearMonthMustPastOrPresent = YearMonth.of(2050, 12);
        // java.time.MonthDay 当月第N天
        obj.monthDayMustPastOrPresent = MonthDay.of(12, 30);

        // 必须是当前日期或过去的日期 fail
        super.validate(obj);
    }
}