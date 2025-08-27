package ru.aveskin.petclinic.owner.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.aveskin.petclinic.owner.dto.*;
import ru.aveskin.petclinic.owner.entity.Owner;
import ru.aveskin.petclinic.owner.mapper.*;
import ru.aveskin.petclinic.owner.repository.OwnerRepository;
import ru.aveskin.petclinic.owner.service.OwnerService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final OwnerRequestCreateToOwnerMapper ownerRequestCreateToOwnerMapper;
    private final OwnerRequestUpdToOwnerMapper ownerRequestUpdToOwnerMapper;
    private final OwnerToOwnerUpdatedResponseMapper ownerToOwnerUpdatedResponseMapper;
    private final OwnerPageToOwnerPageResponseMapper ownerPageToOwnerPageResponseMapper;
    private final OwnerToOwnerResponseMapper ownerToOwnerResponseMapper;

    @Override
    public void create(CreateOwnerRequestDto request) {
        if (ownerRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("Owner with this email already exists");
        }
        ownerRepository.save(ownerRequestCreateToOwnerMapper.map(request));
    }

    @Override
    public void delete(Long id) {
        if (ownerRepository.existsById(id)) {
            throw new IllegalArgumentException("Owner with this id not exists");
        }
        ownerRepository.deleteById(id);
    }

    @Override
    public ChangeOwnerResponseDto update(Long id, ChangeOwnerRequestDto request) {
        Owner owner = ownerRequestUpdToOwnerMapper.map(request);
        ownerRepository.save(owner);
        return ownerToOwnerUpdatedResponseMapper.map(owner);
    }

    @Override
    public OwnersPageResponseDto findOwners(OwnerFindRequest findRequest) {
        Sort sort = Sort.by(Sort.Direction.DESC);
        Pageable pageable = PageRequest.of(findRequest.page(), findRequest.limit(), sort);
        Page<Owner> pageableOwnerResult = findAllOwners(pageable);
        return ownerPageToOwnerPageResponseMapper.map(pageableOwnerResult);
    }

    @Override
    public OwnerResponseDto findOwner(Long id) {
        Optional<Owner> ownerOp = ownerRepository.findById(id);

        Owner owner = ownerOp.orElseThrow(() -> new RuntimeException("Owner not found"));

        return ownerToOwnerResponseMapper.map(owner);
    }

    private Page<Owner> findAllOwners(Pageable pageable) {
        return ownerRepository.findAll(pageable);
    }
}
