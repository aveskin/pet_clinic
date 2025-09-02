package ru.aveskin.petclinic.pet.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.aveskin.petclinic.pet.dto.ChangePetRequestDto;
import ru.aveskin.petclinic.pet.entity.Pet;
import ru.aveskin.petclinic.pet.mapper.PetRequestUpdateToPetMapper;
import ru.aveskin.petclinic.pet.repository.PetRepository;

@Component
@RequiredArgsConstructor
public class PetRequestUpdateToPetMapperImpl implements PetRequestUpdateToPetMapper {
    private final PetRepository petRepository;

    @Override
    public Pet map(ChangePetRequestDto source) {
        var petOP = petRepository.findById(source.getId());
        Pet pet = petOP.orElseThrow(()-> new RuntimeException("Pet not found"));
        pet.setName(source.getName());
        return pet;
    }
}
