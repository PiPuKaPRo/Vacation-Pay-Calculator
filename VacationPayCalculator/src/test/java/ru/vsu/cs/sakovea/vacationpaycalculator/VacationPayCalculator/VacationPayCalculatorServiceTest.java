package ru.vsu.cs.sakovea.vacationpaycalculator.VacationPayCalculator;

import org.junit.jupiter.api.Test;
import ru.vsu.cs.sakovea.vacationpaycalculator.VacationPayCalculator.service.CalculateService;

import java.time.LocalDate;
import java.util.List;

public class VacationPayCalculatorServiceTest {

    private final CalculateService calculateService = new CalculateService();

    @Test
    public void testCalculateVacationPay() {
        double averageSalary = 75000;
        int vacationDays = 15;
        double vacationPay = calculateService.calculateVacationPay(averageSalary, vacationDays);
        System.out.println("Vacation pay is: " + vacationPay);
    }

    @Test
    public void testCalculateVacationPayWithExactDates() {
        double averageSalary = 75000;
        List<LocalDate> exactDates = List.of(
                LocalDate.of(2025, 1, 1),
                LocalDate.of(2025, 1, 3),
                LocalDate.of(2025, 2, 23),
                LocalDate.of(2025, 1, 7)
        );
        double vacationPay = calculateService.calculateVacationPayWithExactDates(averageSalary, exactDates);
        System.out.println("Vacation pay is: " + vacationPay);
    }
}
