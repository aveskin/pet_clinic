package ru.aveskin.petclinic.visit.dto;

import java.time.LocalDateTime;

public record ChangeVisitRequestDto(
        LocalDateTime visitDate,
        String description
) {
}
