package ru.aveskin.petclinic.owner.service;

import ru.aveskin.petclinic.owner.dto.*;

public interface OwnerService {
    void create(CreateOwnerRequestDto request);

    void delete(Long id);

    ChangeOwnerResponseDto update(Long id, ChangeOwnerRequestDto request);

    OwnersPageResponseDto findOwners(OwnerFindRequest ownerFindRequest);

    OwnerResponseDto findOwner(Long id);
}
