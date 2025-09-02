package ru.aveskin.petclinic.visit.dto;

import ru.aveskin.petclinic.visit.entity.Visit;

import java.util.Collection;

public record VisitsPageResponseDto(
        long totalVisits,
        boolean isFirstPage,
        boolean isLastPage,
        Collection<Visit> visits
) {
}
