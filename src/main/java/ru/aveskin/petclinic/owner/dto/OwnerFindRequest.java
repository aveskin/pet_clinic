package ru.aveskin.petclinic.owner.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record OwnerFindRequest(
        @Min(0) int page,
        @Min(25) @Max(100) int limit
) {
}
