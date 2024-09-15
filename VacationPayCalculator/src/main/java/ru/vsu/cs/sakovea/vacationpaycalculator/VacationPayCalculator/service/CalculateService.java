package ru.vsu.cs.sakovea.vacationpaycalculator.VacationPayCalculator.service;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.List;
import java.util.Set;

@Service
public class CalculateService {
    private final Set<MonthDay> holidays = Set.of(
            MonthDay.of(1, 1),
            MonthDay.of(2, 23),
            MonthDay.of(5, 1),
            MonthDay.of(6, 12),
            MonthDay.of(11, 4)
    );
    private static final double AVERAGE_MONTH_DAYS = 29.3;

    public double calculateVacationPay(double averageSalary, int vacationDays) {
        return (averageSalary / AVERAGE_MONTH_DAYS) * vacationDays;
    }

    public double calculateVacationPayWithExactDates(double averageSalary, List<LocalDate> exactDates) {
        int actualVacationDays = (int) exactDates.stream()
                .filter(date -> !isHolidayOrWeekend(date))
                .count();
        return (averageSalary / AVERAGE_MONTH_DAYS) * actualVacationDays;
    }

    public boolean isHolidayOrWeekend(LocalDate date) {
        return isWeekend(date) || isHoliday(date);
    }

    private boolean isWeekend(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    private boolean isHoliday(LocalDate date) {
        return holidays.contains(MonthDay.from(date));
    }
}
