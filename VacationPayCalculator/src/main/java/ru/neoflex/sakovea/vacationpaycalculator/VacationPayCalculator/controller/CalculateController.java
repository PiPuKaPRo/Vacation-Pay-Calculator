package ru.neoflex.sakovea.vacationpaycalculator.VacationPayCalculator.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.neoflex.sakovea.vacationpaycalculator.VacationPayCalculator.dto.VacationPayResponse;

import javax.validation.Valid;
import java.time.LocalDate;

@RequestMapping
@Tag(name = "Vacation Calculator", description = "API для расчета отпускных выплат")
public interface CalculateController {

    @Operation(summary = "Рассчет отпускных")
    @GetMapping("/calculate")
    ResponseEntity<VacationPayResponse> calculateVacationPay(@Valid @RequestParam("salary") double salary,
                                                             @Valid @RequestParam("vacationDays") int vacationDays,
                                                             @Valid @RequestParam(value = "startDate", required = false)
                                                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate);
}
