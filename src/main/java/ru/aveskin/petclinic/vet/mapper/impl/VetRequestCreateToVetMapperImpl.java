package ru.aveskin.petclinic.vet.mapper.impl;

import org.springframework.stereotype.Component;
import ru.aveskin.petclinic.vet.dto.CreateVetRequestDto;
import ru.aveskin.petclinic.vet.entity.Vet;
import ru.aveskin.petclinic.vet.mapper.VetRequestCreateToVetMapper;

@Component
public class VetRequestCreateToVetMapperImpl implements VetRequestCreateToVetMapper {

    @Override
    public Vet map(CreateVetRequestDto source) {
        Vet vet = new Vet();
        vet.setEmail(source.email());
        vet.setPhone(source.phone());
        vet.setSpecialization(source.specialization());
        vet.setLastName(source.lastName());
        vet.setFirstName(source.firstName());

        return vet;
    }
}
