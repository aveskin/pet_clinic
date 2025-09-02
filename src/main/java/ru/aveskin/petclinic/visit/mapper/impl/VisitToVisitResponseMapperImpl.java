package ru.aveskin.petclinic.visit.mapper.impl;

import org.springframework.stereotype.Component;
import ru.aveskin.petclinic.visit.dto.VisitResponseDto;
import ru.aveskin.petclinic.visit.entity.Visit;
import ru.aveskin.petclinic.visit.mapper.VisitToVisitResponseMapper;

@Component
public class VisitToVisitResponseMapperImpl implements VisitToVisitResponseMapper {
    @Override
    public VisitResponseDto map(Visit source) {
        return new VisitResponseDto(
                source.getId(),
                source.getVisitDate(),
                source.getPet().getId(),
                source.getVet().getId(),
                source.getDescription(),
                source.getBill().getId()
        );
    }
}
