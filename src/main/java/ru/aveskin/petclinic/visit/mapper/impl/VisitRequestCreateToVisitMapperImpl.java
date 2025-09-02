package ru.aveskin.petclinic.visit.mapper.impl;

import org.springframework.stereotype.Component;
import ru.aveskin.petclinic.billing.entity.Bill;
import ru.aveskin.petclinic.pet.entity.Pet;
import ru.aveskin.petclinic.vet.entity.Vet;
import ru.aveskin.petclinic.visit.dto.CreateVisitRequestDto;
import ru.aveskin.petclinic.visit.entity.Visit;
import ru.aveskin.petclinic.visit.mapper.VisitRequestCreateToVisitMapper;

@Component
public class VisitRequestCreateToVisitMapperImpl implements VisitRequestCreateToVisitMapper {

    @Override
    public Visit map(CreateVisitRequestDto source) {
        Visit visit = new Visit();
        visit.setVisitDate(source.visitDate());
        visit.setDescription(source.description());

        Pet pet = new Pet();
        pet.setId(source.petId());
        visit.setPet(pet);

        Vet vet = new Vet();
        vet.setId(source.vetId());
        visit.setVet(vet);

        return visit;
    }
}
