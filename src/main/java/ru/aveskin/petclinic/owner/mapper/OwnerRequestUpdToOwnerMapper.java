package ru.aveskin.petclinic.owner.mapper;

import ru.aveskin.petclinic.owner.dto.ChangeOwnerRequestDto;
import ru.aveskin.petclinic.owner.entity.Owner;
import ru.aveskin.petclinic.security.mapper.Mapper;

public interface OwnerRequestUpdToOwnerMapper extends Mapper<Owner, ChangeOwnerRequestDto> {
}
