package ru.aveskin.petclinic.visit.dto;

import java.time.LocalDateTime;

public record VisitResponseDto(
        Long id,
        LocalDateTime visitDate,
        Long petId,
        Long vetId,
        String description,
        Long billId
) {
}
