package ru.aveskin.petclinic.owner.mapper;

import org.springframework.data.domain.Page;
import ru.aveskin.petclinic.owner.dto.OwnersPageResponseDto;
import ru.aveskin.petclinic.owner.entity.Owner;
import ru.aveskin.petclinic.security.mapper.Mapper;

public interface OwnerPageToOwnerPageResponseMapper extends Mapper<OwnersPageResponseDto, Page<Owner>> {
}
