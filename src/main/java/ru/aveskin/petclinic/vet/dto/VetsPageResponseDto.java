package ru.aveskin.petclinic.vet.dto;

import ru.aveskin.petclinic.vet.entity.Vet;

import java.util.Collection;

public record VetsPageResponseDto(
        long totalOwners,
        boolean isFirstPage,
        boolean isLastPage,
        Collection<Vet> vets
) {
}
