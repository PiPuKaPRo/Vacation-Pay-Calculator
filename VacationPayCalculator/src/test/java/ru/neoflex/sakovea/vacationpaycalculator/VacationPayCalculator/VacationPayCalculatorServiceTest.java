package ru.neoflex.sakovea.vacationpaycalculator.VacationPayCalculator;

import org.junit.jupiter.api.Test;
import ru.neoflex.sakovea.vacationpaycalculator.VacationPayCalculator.service.CalculateService;
import ru.neoflex.sakovea.vacationpaycalculator.VacationPayCalculator.service.HolidayService;

import java.time.LocalDate;

public class VacationPayCalculatorServiceTest {

    private final HolidayService holidayService = new HolidayService();

    private final CalculateService calculateService = new CalculateService(holidayService);

    @Test
    public void testCalculateVacationPay() {
        double averageSalary = 75000;
        int vacationDays = 9;
        LocalDate startDate = null;
        double vacationPay = calculateService.calculateVacationPay(averageSalary, vacationDays, startDate).getVacationPay();
        System.out.println("Vacation pay is: " + vacationPay);
    }

    @Test
    public void testCalculateVacationPayWithExactDates() {
        double averageSalary = 75000;
        int vacationDays = 8;
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        double vacationPay = calculateService.calculateVacationPay(averageSalary, vacationDays, startDate).getVacationPay();
        System.out.println("Vacation pay is: " + vacationPay);
    }
}
