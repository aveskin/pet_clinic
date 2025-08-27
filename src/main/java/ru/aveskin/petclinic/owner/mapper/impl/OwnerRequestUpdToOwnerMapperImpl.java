package ru.aveskin.petclinic.owner.mapper.impl;

import org.springframework.stereotype.Component;
import ru.aveskin.petclinic.owner.dto.ChangeOwnerRequestDto;
import ru.aveskin.petclinic.owner.entity.Owner;
import ru.aveskin.petclinic.owner.mapper.OwnerRequestUpdToOwnerMapper;

@Component
public class OwnerRequestUpdToOwnerMapperImpl implements OwnerRequestUpdToOwnerMapper {
    @Override
    public Owner map(ChangeOwnerRequestDto request) {
        Owner owner = new Owner();
        if (request.firstName() != null && !request.firstName().isBlank()) {
            owner.setFirstName(request.firstName());
        }

        if (request.lastName() != null && !request.lastName().isBlank()) {
            owner.setLastName(request.lastName());
        }

        if (request.phone() != null && !request.phone().isBlank()) {
            owner.setPhone(request.phone());
        }

        if (request.email() != null && !request.email().isBlank()) {
            owner.setEmail(request.email());
        }

        if (request.address() != null && !request.address().isBlank()) {
            owner.setAddress(request.address());
        }

        return owner;
    }
}
