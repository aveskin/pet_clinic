package ru.aveskin.petclinic.pet.dto;

public record PetResponseDto(
        Long id,
        String name,
        String species,
        String breed,
        java.time.LocalDate birthDate
) {
}
