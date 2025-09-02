package ru.aveskin.petclinic.vet.mapper.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import ru.aveskin.petclinic.vet.dto.VetsPageResponseDto;
import ru.aveskin.petclinic.vet.entity.Vet;
import ru.aveskin.petclinic.vet.mapper.VetPageToVetPageResponseMapper;

@Component
public class VetPageToVetPageResponseMapperImpl implements VetPageToVetPageResponseMapper {
    @Override
    public VetsPageResponseDto map(Page<Vet> source) {
        var vets = source.stream()
                .toList();

        return new VetsPageResponseDto(
                source.getTotalElements(),
                source.isFirst(),
                source.isLast(),
                vets);
    }
}
