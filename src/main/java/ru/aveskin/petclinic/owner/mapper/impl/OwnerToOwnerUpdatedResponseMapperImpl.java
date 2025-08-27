package ru.aveskin.petclinic.owner.mapper.impl;

import org.springframework.stereotype.Component;
import ru.aveskin.petclinic.owner.dto.ChangeOwnerResponseDto;
import ru.aveskin.petclinic.owner.entity.Owner;
import ru.aveskin.petclinic.owner.mapper.OwnerToOwnerUpdatedResponseMapper;

@Component
public class OwnerToOwnerUpdatedResponseMapperImpl implements OwnerToOwnerUpdatedResponseMapper {
    @Override
    public ChangeOwnerResponseDto map(Owner owner) {
        return new ChangeOwnerResponseDto(
                owner.getId(),
                owner.getFirstName(),
                owner.getLastName(),
                owner.getPhone(),
                owner.getEmail(),
                owner.getAddress());
    }
}
