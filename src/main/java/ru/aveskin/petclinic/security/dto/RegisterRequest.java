package ru.aveskin.petclinic.security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import ru.aveskin.petclinic.security.model.Roles;

public record RegisterRequest(
        @NotBlank @Email String username,
        @NotBlank String password,
        Roles role) {
}