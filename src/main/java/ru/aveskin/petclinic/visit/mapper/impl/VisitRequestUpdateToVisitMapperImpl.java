package ru.aveskin.petclinic.visit.mapper.impl;

import org.springframework.stereotype.Component;
import ru.aveskin.petclinic.visit.dto.ChangeVisitRequestDto;
import ru.aveskin.petclinic.visit.entity.Visit;
import ru.aveskin.petclinic.visit.mapper.VisitRequestUpdateToVisitMapper;

@Component
public class VisitRequestUpdateToVisitMapperImpl implements VisitRequestUpdateToVisitMapper {
    @Override
    public Visit map(Visit visit, ChangeVisitRequestDto request) {
        if (request == null) return null;

        if (request.visitDate() != null) {
            visit.setVisitDate(request.visitDate());
        }

        if (request.description() != null) {
            visit.setDescription(request.description());
        }

        return visit;
    }
}
