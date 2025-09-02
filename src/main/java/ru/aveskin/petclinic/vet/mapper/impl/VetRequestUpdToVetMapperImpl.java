package ru.aveskin.petclinic.vet.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import ru.aveskin.petclinic.vet.dto.ChangeVetRequestDto;
import ru.aveskin.petclinic.vet.entity.Vet;
import ru.aveskin.petclinic.vet.mapper.VetRequestUpdToVetMapper;

@Component
@RequiredArgsConstructor
public class VetRequestUpdToVetMapperImpl implements VetRequestUpdToVetMapper {


    @Override
    public Vet map(ChangeVetRequestDto source, Vet target) {
        if (source == null || target == null) {
            return target;
        }

        if (StringUtils.hasText(source.firstName())) {
            target.setFirstName(source.firstName());
        }

        if (StringUtils.hasText(source.lastName())) {
            target.setLastName(source.lastName());
        }

        if (StringUtils.hasText(source.specialization())) {
            target.setSpecialization(source.specialization());
        }

        if (StringUtils.hasText(source.phone())) {
            target.setPhone(source.phone());
        }

        if (StringUtils.hasText(source.email())) {
            target.setEmail(source.email());
        }

        return target;
    }
}
