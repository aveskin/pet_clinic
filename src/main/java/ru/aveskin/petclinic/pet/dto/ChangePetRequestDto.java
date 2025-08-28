package ru.aveskin.petclinic.pet.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ChangePetRequestDto {
    @NotBlank
    private String name;

    private LocalDate birthDate;

    @NotBlank
    private String species;

    private String breed;

    private Long ownerId;
}
