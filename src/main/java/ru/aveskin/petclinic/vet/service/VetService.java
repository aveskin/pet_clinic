package ru.aveskin.petclinic.vet.service;

import jakarta.validation.Valid;
import ru.aveskin.petclinic.vet.dto.*;

public interface VetService {
    VetsPageResponseDto findVets(VetFindRequest vetFindRequest);

    VetResponseDto findVet(Long id);

    void create(CreateVetRequestDto request);

    void delete(Long id);

    VetResponseDto update(Long id, ChangeVetRequestDto request);

    VetVisitsResponseDto findVetWithVisits(Long id);
}
