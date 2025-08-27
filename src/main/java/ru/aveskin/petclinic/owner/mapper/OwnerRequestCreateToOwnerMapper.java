package ru.aveskin.petclinic.owner.mapper;

import ru.aveskin.petclinic.owner.dto.CreateOwnerRequestDto;
import ru.aveskin.petclinic.owner.entity.Owner;
import ru.aveskin.petclinic.security.mapper.Mapper;

public interface OwnerRequestCreateToOwnerMapper extends Mapper<Owner, CreateOwnerRequestDto> {
}
