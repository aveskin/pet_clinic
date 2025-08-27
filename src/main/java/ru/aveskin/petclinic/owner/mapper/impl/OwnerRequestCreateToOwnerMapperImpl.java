package ru.aveskin.petclinic.owner.mapper.impl;

import org.springframework.stereotype.Component;
import ru.aveskin.petclinic.owner.dto.CreateOwnerRequestDto;
import ru.aveskin.petclinic.owner.entity.Owner;
import ru.aveskin.petclinic.owner.mapper.OwnerRequestCreateToOwnerMapper;

@Component
public class OwnerRequestCreateToOwnerMapperImpl implements OwnerRequestCreateToOwnerMapper {
    @Override
    public Owner map(CreateOwnerRequestDto request) {
        Owner owner = new Owner();
        owner.setAddress(request.address());
        owner.setEmail(request.email());
        owner.setPhone(request.phone());
        owner.setFirstName(request.firstName());
        owner.setLastName(request.lastName());

        return owner;
    }
}
