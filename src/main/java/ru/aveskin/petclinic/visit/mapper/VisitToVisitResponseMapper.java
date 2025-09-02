package ru.aveskin.petclinic.visit.mapper;

import ru.aveskin.petclinic.security.mapper.Mapper;
import ru.aveskin.petclinic.visit.dto.VisitResponseDto;
import ru.aveskin.petclinic.visit.entity.Visit;

public interface VisitToVisitResponseMapper extends Mapper<VisitResponseDto, Visit> {
}
