package ru.neoflex.sakovea.vacationpaycalculator.VacationPayCalculator.service;

import org.springframework.stereotype.Service;
import ru.neoflex.sakovea.vacationpaycalculator.VacationPayCalculator.dto.VacationPayResponse;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Set;

@Service
public class CalculateService {

    private static final double AVERAGE_MONTH_DAYS = 29.3;

    private final Set<MonthDay> holidays = Set.of(
            MonthDay.of(1, 1),
            MonthDay.of(1, 2),
            MonthDay.of(1, 3),
            MonthDay.of(1, 4),
            MonthDay.of(1, 5),
            MonthDay.of(1, 6),
            MonthDay.of(1, 7),
            MonthDay.of(1, 8),
            MonthDay.of(2, 23),
            MonthDay.of(4, 8),
            MonthDay.of(5, 1),
            MonthDay.of(5, 9),
            MonthDay.of(6, 12),
            MonthDay.of(11, 4)
    );

    public VacationPayResponse calculateVacationPay(double averageSalary, int vacationDays, LocalDate startDate) {
        double vacationPay;
        if (startDate != null) {
            vacationPay = calculateVacationPayWithDates(averageSalary, vacationDays, startDate);
        } else {
            vacationPay = calculateSimpleVacationPay(averageSalary, vacationDays);
        }
        return new VacationPayResponse(vacationPay);
    }

    private double calculateSimpleVacationPay(double averageSalary, int vacationDays) {
        return (averageSalary / AVERAGE_MONTH_DAYS) * vacationDays;
    }

    private double calculateVacationPayWithDates(double averageSalary, int vacationDays, LocalDate startDate) {
        int actualVacationDays = 0;
        int days = 0;
        LocalDate currentDate = startDate;
        while (days < vacationDays) {
            if (!isHolidayOrWeekend(currentDate)) {
                actualVacationDays++;
            }
            currentDate = currentDate.plusDays(1);
            days++;
        }
        return (averageSalary / AVERAGE_MONTH_DAYS) * actualVacationDays;
    }

    public boolean isHolidayOrWeekend(LocalDate date) {
        return isWeekend(date) || isHoliday(date);
    }

    private boolean isWeekend(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    private boolean isHoliday(LocalDate date) {
        return holidays.contains(MonthDay.from(date));
    }
}
