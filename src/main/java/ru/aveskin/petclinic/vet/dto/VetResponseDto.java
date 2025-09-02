package ru.aveskin.petclinic.vet.dto;

public record VetResponseDto(
        Long id,
        String firstName,
        String lastName,
        String specialization,
        String phone,
        String email
) {
}
