package ru.aveskin.petclinic.owner.mapper;

import ru.aveskin.petclinic.owner.dto.ChangeOwnerResponseDto;
import ru.aveskin.petclinic.owner.entity.Owner;
import ru.aveskin.petclinic.security.mapper.Mapper;

public interface OwnerToOwnerUpdatedResponseMapper extends Mapper<ChangeOwnerResponseDto, Owner> {
}
