package ru.neoflex.sakovea.vacationpaycalculator.VacationPayCalculator.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Ответ с отпускными")
public class VacationPayResponse {

    @Schema(description = "Рассчитанные отпускные", example = "6456.234")
    private double vacationPay;
}
