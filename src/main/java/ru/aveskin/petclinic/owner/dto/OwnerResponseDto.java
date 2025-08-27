package ru.aveskin.petclinic.owner.dto;

import ru.aveskin.petclinic.pet.dto.PetResponseDto;

import java.util.List;

public record OwnerResponseDto(
        Long id,
        String firstName,
        String lastName,
        String phone,
        String email,
        String address,
        List<PetResponseDto> pets
) {
}
