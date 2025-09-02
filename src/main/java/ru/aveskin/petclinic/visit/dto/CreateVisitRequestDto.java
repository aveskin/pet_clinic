package ru.aveskin.petclinic.visit.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreateVisitRequestDto(
        @NotNull
        @FutureOrPresent(message = "Visit date must be in the present or future")
        LocalDateTime visitDate,

        @NotNull(message = "Pet id is required")
        Long petId,

        @NotNull(message = "Vet id is required")
        Long vetId,

        String description
) {
}
