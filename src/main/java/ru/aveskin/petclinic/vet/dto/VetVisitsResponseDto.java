package ru.aveskin.petclinic.vet.dto;

import ru.aveskin.petclinic.visit.entity.Visit;

import java.util.List;

public record VetVisitsResponseDto(
        Long id,
        String firstName,
        String lastName,
        String specialization,
        String phone,
        String email,
        List<Visit> visits
) {
}
