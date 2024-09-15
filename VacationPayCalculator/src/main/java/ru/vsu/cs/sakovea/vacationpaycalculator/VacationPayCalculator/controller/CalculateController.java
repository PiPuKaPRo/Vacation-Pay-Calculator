package ru.vsu.cs.sakovea.vacationpaycalculator.VacationPayCalculator.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.sakovea.vacationpaycalculator.VacationPayCalculator.dto.VacationPayRequest;
import ru.vsu.cs.sakovea.vacationpaycalculator.VacationPayCalculator.dto.VacationPayResponse;
import ru.vsu.cs.sakovea.vacationpaycalculator.VacationPayCalculator.service.CalculateService;

@RestController
@RequestMapping("/calculate")
public class CalculateController {

    @Autowired
    private CalculateService calculateService;

    @PostMapping
    public VacationPayResponse calculate(@RequestBody VacationPayRequest request) {
        double vacationPay = request.getExactVacationDays() != null && !request.getExactVacationDays().isEmpty()
                ? calculateService.calculateVacationPayWithExactDates(request.getSalary(), request.getExactVacationDays())
                : calculateService.calculateVacationPay(request.getSalary(), request.getVacationDays());

        return new VacationPayResponse(vacationPay);
    }
}
