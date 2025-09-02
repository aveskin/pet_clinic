package ru.aveskin.petclinic.vet.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record VetFindRequest(
        @Min(0) int page,
        @Min(25) @Max(100) int limit
) {
}
