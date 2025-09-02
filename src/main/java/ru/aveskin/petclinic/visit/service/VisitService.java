package ru.aveskin.petclinic.visit.service;

import jakarta.validation.Valid;
import ru.aveskin.petclinic.visit.dto.*;

public interface VisitService {
    VisitsPageResponseDto findVisits(VisitFindRequest visitFindRequest);

    VisitResponseDto findVisit(Long id);

    void create(CreateVisitRequestDto request);

    VisitResponseDto update(Long id, ChangeVisitRequestDto request);

    void delete(Long id);
}
