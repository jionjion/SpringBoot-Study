package top.jionjion.validation.jsr303.datetime;

import org.junit.jupiter.api.Test;
import top.jionjion.validation.ValidationBaseTest;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

class FutureOrPresentOrPresentValidationTest extends ValidationBaseTest {

    @Test
    @SuppressWarnings("MagicConstant")
    public void test() {
        FutureOrPresentValidation obj = new FutureOrPresentValidation();
        // java.util.Date 日期 + 时间 + 时区
        obj.dateMustFutureOrPresent = new Date(System.currentTimeMillis() - 10000);
        // java.util.Calendar 日期
        obj.calendarMustFutureOrPresent = Calendar.getInstance();
        obj.calendarMustFutureOrPresent.set(2020, 1, 1);

        // java.time.Instant 精确时间点， 日期 + 时间 + 时区
        obj.instantMustFutureOrPresent = Instant.now().minus(1, ChronoUnit.DAYS);
        // java.time.ZonedDateTime 日期 + 时间 + 时区
        obj.zonedDateTimeMustFutureOrPresent = ZonedDateTime.of(2020, 1, 1, 0, 0, 0, 0, ZoneId.systemDefault());
        // java.time.LocalDateTime  日期 + 时间
        obj.localDateTimeMustFutureOrPresent = LocalDateTime.MIN;
        // java.time.LocalDate 日期
        obj.localDateMustFutureOrPresent = LocalDate.of(2020, 1, 1);
        // java.time.LocalTime 时间
        obj.localTimeMustFutureOrPresent = LocalTime.MIN;
        // java.time.OffsetDateTime 日期 + 时间 + 时区
        obj.offsetDateTimeMustFutureOrPresent = OffsetDateTime.MIN;
        // java.time.OffsetTime 时间 + 时区
        obj.offsetTimeMustFutureOrPresent = OffsetTime.MIN;

        // java.time.Year 第N年
        obj.yearMustFutureOrPresent = Year.of(2020);
        // java.time.YearMonth 当年第N月
        obj.yearMonthMustFutureOrPresent = YearMonth.of(2020, 1);
        // java.time.MonthDay 当月第N天
        obj.monthDayMustFutureOrPresent = MonthDay.of(1, 1);

        // 必须是当前日期或将来的日期 fail
        super.validate(obj);
    }
}