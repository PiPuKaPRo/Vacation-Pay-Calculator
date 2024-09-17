package ru.neoflex.sakovea.vacationpaycalculator.VacationPayCalculator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.neoflex.sakovea.vacationpaycalculator.VacationPayCalculator.dto.VacationPayRequest;
import ru.neoflex.sakovea.vacationpaycalculator.VacationPayCalculator.dto.VacationPayResponse;
import ru.neoflex.sakovea.vacationpaycalculator.VacationPayCalculator.service.CalculateService;

import java.time.LocalDate;


@RestController
@RequiredArgsConstructor
public class CalculateControllerImpl implements CalculateController {

    @Autowired
    private final CalculateService calculateService;


    @Override
    public ResponseEntity<VacationPayResponse> calculateVacationPay(double salary, int vacationDays, LocalDate startDate) {
        var request = new VacationPayRequest(salary, vacationDays, startDate);
        VacationPayResponse response = calculateService.calculateVacationPay(request.getSalary(),
                request.getVacationDays(), request.getExactVacationDayStart());
        return ResponseEntity.ok(response);
    }
}
