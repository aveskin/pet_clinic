package ru.aveskin.petclinic.visit.mapper.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import ru.aveskin.petclinic.visit.dto.VisitsPageResponseDto;
import ru.aveskin.petclinic.visit.entity.Visit;
import ru.aveskin.petclinic.visit.mapper.VisitPageToVisitPageResponseMapper;

@Component
public class VisitPageToVisitPageResponseMapperImpl implements VisitPageToVisitPageResponseMapper {
    @Override
    public VisitsPageResponseDto map(Page<Visit> source) {
        var visits = source.stream()
                .toList();

        return new VisitsPageResponseDto(
                source.getTotalElements(),
                source.isFirst(),
                source.isLast(),
                visits);
    }
}
