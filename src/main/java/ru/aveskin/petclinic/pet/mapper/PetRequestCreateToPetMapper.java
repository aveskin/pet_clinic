package ru.aveskin.petclinic.pet.mapper;

import ru.aveskin.petclinic.pet.dto.CreatePetRequestDto;
import ru.aveskin.petclinic.pet.entity.Pet;
import ru.aveskin.petclinic.security.mapper.Mapper;

public interface PetRequestCreateToPetMapper extends Mapper<Pet, CreatePetRequestDto> {
}
