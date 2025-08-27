package ru.aveskin.petclinic.owner.mapper.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.aveskin.petclinic.owner.dto.OwnersPageResponseDto;
import ru.aveskin.petclinic.owner.entity.Owner;
import ru.aveskin.petclinic.owner.mapper.OwnerPageToOwnerPageResponseMapper;


@Service
public class OwnerPageToOwnerPageResponseMapperImpl implements OwnerPageToOwnerPageResponseMapper {
    @Override
    public OwnersPageResponseDto map(Page<Owner> source) {

        var owners = source.stream()
                .toList();

        return new OwnersPageResponseDto(
                source.getTotalElements(),
                source.isFirst(),
                source.isLast(),
                owners);
    }
}
