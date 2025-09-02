package ru.aveskin.petclinic.vet.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateVetRequestDto(
        @NotBlank
        String firstName,

        @NotBlank
        String lastName,

        String specialization,

        String phone,

        @Email
        @NotBlank
        String email
) {
}
