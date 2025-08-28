package ru.aveskin.petclinic.pet.dto;


import java.time.LocalDate;

public record ChangePetResponseDto(
        String name,

        LocalDate birthDate,

        String species,

        String breed,

        Long ownerId
) {

}
