package ru.aveskin.petclinic.visit.mapper;

import org.springframework.data.domain.Page;
import ru.aveskin.petclinic.security.mapper.Mapper;
import ru.aveskin.petclinic.visit.dto.VisitsPageResponseDto;
import ru.aveskin.petclinic.visit.entity.Visit;

public interface VisitPageToVisitPageResponseMapper extends Mapper<VisitsPageResponseDto, Page<Visit>> {
}
