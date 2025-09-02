package ru.aveskin.petclinic.visit.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aveskin.petclinic.billing.entity.Bill;
import ru.aveskin.petclinic.billing.entity.BillStatus;
import ru.aveskin.petclinic.pet.repository.PetRepository;
import ru.aveskin.petclinic.vet.repository.VetRepository;
import ru.aveskin.petclinic.visit.dto.*;
import ru.aveskin.petclinic.visit.entity.Visit;
import ru.aveskin.petclinic.visit.mapper.VisitPageToVisitPageResponseMapper;
import ru.aveskin.petclinic.visit.mapper.VisitRequestCreateToVisitMapper;
import ru.aveskin.petclinic.visit.mapper.VisitRequestUpdateToVisitMapper;
import ru.aveskin.petclinic.visit.mapper.VisitToVisitResponseMapper;
import ru.aveskin.petclinic.visit.repository.VisitRepository;
import ru.aveskin.petclinic.visit.service.VisitService;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class VisitServiceImpl implements VisitService {
    private final VisitRepository visitRepository;
    private final PetRepository petRepository;
    private final VetRepository vetRepository;
    private final VisitPageToVisitPageResponseMapper visitPageToVisitPageResponseMapper;
    private final VisitToVisitResponseMapper visitToVisitResponseMapper;
    private final VisitRequestCreateToVisitMapper visitRequestCreateToVisitMapper;
    private final VisitRequestUpdateToVisitMapper visitRequestUpdateToVisitMapper;

    @Override
    @Transactional(readOnly = true)
    public VisitsPageResponseDto findVisits(VisitFindRequest findRequest) {
        Sort sort = Sort.by(Sort.Direction.DESC);
        Pageable pageable = PageRequest.of(findRequest.page(), findRequest.limit(), sort);
        Page<Visit> pageableVisitResult = visitRepository.findAll(pageable);
        return visitPageToVisitPageResponseMapper.map(pageableVisitResult);
    }

    @Override
    @Transactional(readOnly = true)
    public VisitResponseDto findVisit(Long id) {
        Visit visit = visitRepository.findVisitWithRelationsById(id)
                .orElseThrow(() -> new RuntimeException("Visit not found"));
        return visitToVisitResponseMapper.map(visit);
    }

    @Override
    @Transactional
    public void create(CreateVisitRequestDto request) {
        var pet = petRepository.findById(request.petId())
                .orElseThrow(() -> new IllegalArgumentException("Pet not found with id " + request.petId()));

        var vet = vetRepository.findById(request.vetId())
                .orElseThrow(() -> new IllegalArgumentException("Vet not found with id " + request.vetId()));


        Visit visit = visitRequestCreateToVisitMapper.map(request);
        visit.setVet(vet);
        visit.setPet(pet);

        createDraftBillForVisit(visit);

        visitRepository.save(visit);
    }

    @Override
    public VisitResponseDto update(Long id, ChangeVisitRequestDto request) {
        Visit visit = visitRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Visit not found with id " + id));

        Visit changedVisit = visitRequestUpdateToVisitMapper.map(visit, request);
        visitRepository.save(changedVisit);

        return visitToVisitResponseMapper.map(changedVisit);
    }

    @Override
    public void delete(Long id) {
        if (!visitRepository.existsById(id)) {
            throw new IllegalArgumentException("Visit not found with id " + id);
        }
        visitRepository.deleteById(id);
    }

    private void createDraftBillForVisit(Visit visit) {
        Bill bill = new Bill();
        bill.setVisit(visit);
        bill.setStatus(BillStatus.DRAFT);
        bill.setAmount(BigDecimal.ZERO);

        visit.setBill(bill);
    }

}
