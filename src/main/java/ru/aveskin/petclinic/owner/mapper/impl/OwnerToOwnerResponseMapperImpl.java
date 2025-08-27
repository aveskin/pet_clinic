package ru.aveskin.petclinic.owner.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.aveskin.petclinic.owner.dto.OwnerResponseDto;
import ru.aveskin.petclinic.owner.entity.Owner;
import ru.aveskin.petclinic.owner.mapper.OwnerToOwnerResponseMapper;
import ru.aveskin.petclinic.pet.mapper.PetToPetResponseMapper;

@Component
@RequiredArgsConstructor
public class OwnerToOwnerResponseMapperImpl implements OwnerToOwnerResponseMapper {
    private final PetToPetResponseMapper petToPetResponseMapper;

    @Override
    public OwnerResponseDto map(Owner source) {
        return new OwnerResponseDto(
                source.getId(),
                source.getFirstName(),
                source.getLastName(),
                source.getPhone(),
                source.getEmail(),
                source.getAddress(),
                source.getPets()
                        .stream()
                        .map(petToPetResponseMapper::map)
                        .toList()
        );
    }
}
