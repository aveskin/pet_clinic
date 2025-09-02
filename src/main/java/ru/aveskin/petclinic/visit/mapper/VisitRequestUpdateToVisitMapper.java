package ru.aveskin.petclinic.visit.mapper;

import ru.aveskin.petclinic.visit.dto.ChangeVisitRequestDto;
import ru.aveskin.petclinic.visit.entity.Visit;

public interface VisitRequestUpdateToVisitMapper {
    Visit map(Visit visit, ChangeVisitRequestDto changeVisitRequestDto);
}
