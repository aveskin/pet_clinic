package ru.aveskin.petclinic.vet.dto;


public record ChangeVetRequestDto(
        String firstName,
        String lastName,
        String specialization,
        String phone,
        String email
) {
}
