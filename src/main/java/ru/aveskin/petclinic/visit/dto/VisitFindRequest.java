package ru.aveskin.petclinic.visit.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record VisitFindRequest(
        @Min(0) int page,
        @Min(25) @Max(100) int limit
) {
}
