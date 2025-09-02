package ru.aveskin.petclinic.pet.mapper;


import ru.aveskin.petclinic.pet.dto.ChangePetRequestDto;
import ru.aveskin.petclinic.pet.entity.Pet;
import ru.aveskin.petclinic.security.mapper.Mapper;

public interface PetRequestUpdateToPetMapper extends Mapper<Pet, ChangePetRequestDto> {
}
