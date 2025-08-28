package ru.aveskin.petclinic.pet.mapper.impl;

import org.springframework.stereotype.Component;
import ru.aveskin.petclinic.pet.dto.CreatePetRequestDto;
import ru.aveskin.petclinic.pet.entity.Pet;
import ru.aveskin.petclinic.pet.mapper.PetRequestCreateToPetMapper;

@Component
public class PetRequestCreateToPetMapperImpl implements PetRequestCreateToPetMapper {

    @Override
    public Pet map(CreatePetRequestDto source) {
        Pet pet = new Pet();
        pet.setBirthDate(source.getBirthDate());
        pet.setName(source.getName());
        pet.setSpecies(source.getSpecies());
        pet.setBreed(source.getBreed());

        return pet;
    }
}
