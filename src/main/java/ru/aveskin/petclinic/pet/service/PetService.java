package ru.aveskin.petclinic.pet.service;

import ru.aveskin.petclinic.pet.dto.ChangePetRequestDto;
import ru.aveskin.petclinic.pet.dto.ChangePetResponseDto;
import ru.aveskin.petclinic.pet.dto.CreatePetRequestDto;
import ru.aveskin.petclinic.pet.dto.PetResponseDto;

import java.util.List;

public interface PetService {
    List<PetResponseDto> findPetsByOwner(Long ownerId);

    List<PetResponseDto> findPetsForCurrentOwner();

    void create(CreatePetRequestDto request);

    void delete(Long id);

    ChangePetResponseDto update(Long id, ChangePetRequestDto request);
}
