package ru.aveskin.petclinic.owner.dto;

public record ChangeOwnerResponseDto(
        Long id,
        String firstName,
        String lastName,
        String phone,
        String email,
        String address
) {}