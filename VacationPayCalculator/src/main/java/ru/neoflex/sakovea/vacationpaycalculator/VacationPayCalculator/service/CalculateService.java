package ru.neoflex.sakovea.vacationpaycalculator.VacationPayCalculator.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.neoflex.sakovea.vacationpaycalculator.VacationPayCalculator.dto.VacationPayResponse;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class CalculateService {

    private static final double AVERAGE_MONTH_DAYS = 29.3;

    @Autowired
    private final HolidayService holidayService;

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
            if (!holidayService.isHolidayOrWeekend(currentDate)) {
                actualVacationDays++;
            }
            currentDate = currentDate.plusDays(1);
            days++;
        }
        return (averageSalary / AVERAGE_MONTH_DAYS) * actualVacationDays;
    }


}
