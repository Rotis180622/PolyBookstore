package com.mycompany.projectone.util;

import java.time.LocalDate;
import lombok.Data;

@Data
public class TimeRange {

    private LocalDate begin;
    private LocalDate end;

    private TimeRange(LocalDate begin, LocalDate end) {
        this.begin = begin;
        this.end = end;
    }

    public static TimeRange today() {
        LocalDate now = LocalDate.now();
        return new TimeRange(now, now); 
    }

    public static TimeRange thisWeek() {
        LocalDate now = LocalDate.now();
        LocalDate begin = now.minusDays(now.getDayOfWeek().getValue() - 1); // Thứ Hai
        LocalDate end = begin.plusDays(6); 
        return new TimeRange(begin, end);
    }

    public static TimeRange thisMonth() {
        LocalDate now = LocalDate.now();
        LocalDate begin = now.withDayOfMonth(1);
        LocalDate end = begin.plusMonths(1).minusDays(1); // Ngày cuối tháng
        return new TimeRange(begin, end);
    }

    public static TimeRange thisQuarter() {
        LocalDate now = LocalDate.now();
        int firstMonth = now.getMonth().firstMonthOfQuarter().getValue();
        LocalDate begin = now.withMonth(firstMonth).withDayOfMonth(1);
        LocalDate end = begin.plusMonths(3).minusDays(1); // Ngày cuối quý
        return new TimeRange(begin, end);
    }

    public static TimeRange thisYear() {
        LocalDate now = LocalDate.now();
        LocalDate begin = now.withMonth(1).withDayOfMonth(1);
        LocalDate end = begin.plusYears(1).minusDays(1); // Ngày cuối năm
        return new TimeRange(begin, end);
    }
}