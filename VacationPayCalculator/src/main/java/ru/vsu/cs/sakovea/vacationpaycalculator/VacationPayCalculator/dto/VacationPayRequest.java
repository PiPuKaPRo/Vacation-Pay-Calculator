package ru.vsu.cs.sakovea.vacationpaycalculator.VacationPayCalculator.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class VacationPayRequest {

    private double salary;

    private int vacationDays;

    private List<LocalDate> exactVacationDays;
}
