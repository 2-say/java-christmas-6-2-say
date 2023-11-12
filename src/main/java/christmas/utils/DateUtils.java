package christmas.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class DateUtils {

    public static boolean isWeekday(LocalDate date) {
        return getDayOfWeekValue(date) >= DayOfWeek.SUNDAY.getValue() ||
                getDayOfWeekValue(date) <= DayOfWeek.THURSDAY.getValue();
    }

    public static boolean isWeekend(LocalDate date) {
        return getDayOfWeekValue(date) >= DayOfWeek.FRIDAY.getValue() &&
                getDayOfWeekValue(date) <= DayOfWeek.SATURDAY.getValue();
    }

    public static boolean isDayOfMonthInRange(LocalDate date, int startDay, int endDay) {
        int dayOfMonth = date.getDayOfMonth();
        return dayOfMonth >= startDay && dayOfMonth <= endDay;
    }

    private static int getDayOfWeekValue(LocalDate date) {
        return date.getDayOfWeek().getValue();
    }

    public static boolean isStarDay(LocalDate date) {
        return getDayOfWeekValue(date) == DayOfWeek.SUNDAY.getValue() || date.getDayOfMonth() == 25;
    }

    public static boolean isDecemberAndInRange(LocalDate date, int startDay, int endDay) {
        return DateUtils.isDayOfMonthInRange(date, startDay, endDay);
    }

}
