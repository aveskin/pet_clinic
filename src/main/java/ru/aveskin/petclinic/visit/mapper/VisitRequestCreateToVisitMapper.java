package ru.aveskin.petclinic.visit.mapper;

import ru.aveskin.petclinic.security.mapper.Mapper;
import ru.aveskin.petclinic.visit.dto.CreateVisitRequestDto;
import ru.aveskin.petclinic.visit.entity.Visit;

public interface VisitRequestCreateToVisitMapper extends Mapper<Visit, CreateVisitRequestDto> {
}
