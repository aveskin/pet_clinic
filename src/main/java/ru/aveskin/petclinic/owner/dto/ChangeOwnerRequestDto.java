package ru.aveskin.petclinic.owner.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record ChangeOwnerRequestDto(

        @Size(max = 50, message = "First name must be at most 50 characters")
        String firstName,

        @Size(max = 50, message = "Last name must be at most 50 characters")
        String lastName,

        @Size(max = 20, message = "Phone number must be at most 20 characters")
        String phone,

        @Email(message = "Email should be valid")
        @Size(max = 100, message = "Email must be at most 100 characters")
        String email,

        @Size(max = 255, message = "Address must be at most 255 characters")
        String address
) {}