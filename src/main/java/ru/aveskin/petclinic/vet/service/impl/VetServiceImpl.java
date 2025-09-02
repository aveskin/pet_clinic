package ru.aveskin.petclinic.vet.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aveskin.petclinic.vet.dto.*;
import ru.aveskin.petclinic.vet.entity.Vet;
import ru.aveskin.petclinic.vet.mapper.*;
import ru.aveskin.petclinic.vet.repository.VetRepository;
import ru.aveskin.petclinic.vet.service.VetService;

@RequiredArgsConstructor
@Service
public class VetServiceImpl implements VetService {
    private final VetRepository vetRepository;
    private final VetPageToVetPageResponseMapper vetPageToVetPageResponseMapper;
    private final VetToVetResponseMapper vetToVetResponseMapper;
    private final VetRequestCreateToVetMapper vetRequestCreateToVetMapper;
    private final VetRequestUpdToVetMapper vetRequestUpdToVetMapper;
    private final VetToVetVisitsResponseMapper vetToVetVisitsResponseMapper;

    @Override
    @Transactional(readOnly = true)
    public VetsPageResponseDto findVets(VetFindRequest findRequest) {
        Sort sort = Sort.by(Sort.Direction.DESC);
        Pageable pageable = PageRequest.of(findRequest.page(), findRequest.limit(), sort);
        Page<Vet> pageableVetResult = findAllVets(pageable);
        return vetPageToVetPageResponseMapper.map(pageableVetResult);
    }

    @Override
    @Transactional(readOnly = true)
    public VetResponseDto findVet(Long id) {
        Vet vet = vetRepository.findById(id).orElseThrow(() -> new RuntimeException("Vet not found"));
        return vetToVetResponseMapper.map(vet);
    }

    @Override
    @Transactional
    public void create(CreateVetRequestDto request) {
        if (vetRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("Vet with this email already exists");
        }
        vetRepository.save(vetRequestCreateToVetMapper.map(request));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!vetRepository.existsById(id)) {
            throw new IllegalArgumentException("Vet with this id not exists");
        }
        vetRepository.deleteById(id);
    }

    @Override
    @Transactional
    public VetResponseDto update(Long id, ChangeVetRequestDto request) {
        Vet vet = vetRepository.findById(id).orElseThrow(() -> new RuntimeException("Vet not found"));

        Vet changedVet = vetRequestUpdToVetMapper.map(request, vet);
        vetRepository.save(changedVet);
        return vetToVetResponseMapper.map(changedVet);
    }

    @Override
    @Transactional(readOnly = true)
    public VetVisitsResponseDto findVetWithVisits(Long id) {
        Vet vet = vetRepository.findVetWithVisitsById(id).orElseThrow(() -> new RuntimeException("Vet not found"));

        return vetToVetVisitsResponseMapper.map(vet);
    }

    private Page<Vet> findAllVets(Pageable pageable) {
        return vetRepository.findAll(pageable);
    }
}
