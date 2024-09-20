package ru.neoflex.sakovea.vacationpaycalculator.VacationPayCalculator.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;


@Data
@Schema(description = "Запрос для рассчета отпускных")
@AllArgsConstructor
public class VacationPayRequest {

    @Schema(description = "Зарплата", example = "75000")
    private double salary;

    @Schema(description = "Количество дней отпуска", example = "10")
    private int vacationDays;

    @Schema(description = "Конкретная дата начала отпуска", example = "\"2024-01-02\"")
    private LocalDate exactVacationDayStart;
}
