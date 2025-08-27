package ru.aveskin.petclinic.owner.dto;

import ru.aveskin.petclinic.owner.entity.Owner;

import java.util.Collection;

public record OwnersPageResponseDto(
        long totalOwners,
        boolean isFirstPage,
        boolean isLastPage,
        Collection<Owner> owners
) {
}
