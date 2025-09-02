package ru.aveskin.petclinic.vet.mapper.impl;

import org.springframework.stereotype.Component;
import ru.aveskin.petclinic.vet.dto.VetResponseDto;
import ru.aveskin.petclinic.vet.entity.Vet;
import ru.aveskin.petclinic.vet.mapper.VetToVetResponseMapper;

@Component
public class VetToVetResponseMapperImpl implements VetToVetResponseMapper {
    @Override
    public VetResponseDto map(Vet source) {
        return new VetResponseDto(
                source.getId(),
                source.getFirstName(),
                source.getLastName(),
                source.getSpecialization(),
                source.getPhone(),
                source.getEmail());
    }
}
