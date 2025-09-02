package ru.aveskin.petclinic.vet.mapper.impl;

import org.springframework.stereotype.Component;
import ru.aveskin.petclinic.vet.dto.VetVisitsResponseDto;
import ru.aveskin.petclinic.vet.entity.Vet;
import ru.aveskin.petclinic.vet.mapper.VetToVetVisitsResponseMapper;

@Component
public class VetToVetVisitsResponseMapperImpl implements VetToVetVisitsResponseMapper {

    @Override
    public VetVisitsResponseDto map(Vet source) {
        if (source == null) {
            return null;
        }
        var visitsDto = source.getVisits();
        return new VetVisitsResponseDto(
                source.getId(),
                source.getFirstName(),
                source.getLastName(),
                source.getSpecialization(),
                source.getPhone(),
                source.getEmail(),
                visitsDto);
    }
}
