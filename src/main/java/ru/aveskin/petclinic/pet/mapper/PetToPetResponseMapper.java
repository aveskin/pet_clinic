package ru.aveskin.petclinic.pet.mapper;


import ru.aveskin.petclinic.pet.dto.PetResponseDto;
import ru.aveskin.petclinic.pet.entity.Pet;
import ru.aveskin.petclinic.security.mapper.Mapper;

public interface PetToPetResponseMapper extends Mapper<PetResponseDto, Pet> {
}
