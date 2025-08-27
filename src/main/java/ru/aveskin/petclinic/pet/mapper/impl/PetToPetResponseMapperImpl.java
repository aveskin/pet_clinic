package ru.aveskin.petclinic.pet.mapper.impl;

import org.springframework.stereotype.Component;
import ru.aveskin.petclinic.pet.dto.PetResponseDto;
import ru.aveskin.petclinic.pet.entity.Pet;
import ru.aveskin.petclinic.pet.mapper.PetToPetResponseMapper;

@Component
public class PetToPetResponseMapperImpl implements PetToPetResponseMapper {
    @Override
    public PetResponseDto map(Pet pet) {
        return new PetResponseDto(
                pet.getId(),
                pet.getName(),
                pet.getSpecies(),
                pet.getBreed(),
                pet.getBirthDate()
        );
    }
}
