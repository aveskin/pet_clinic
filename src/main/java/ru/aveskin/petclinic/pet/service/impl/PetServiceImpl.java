package ru.aveskin.petclinic.pet.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aveskin.petclinic.pet.dto.ChangePetRequestDto;
import ru.aveskin.petclinic.pet.dto.ChangePetResponseDto;
import ru.aveskin.petclinic.pet.dto.CreatePetRequestDto;
import ru.aveskin.petclinic.pet.dto.PetResponseDto;
import ru.aveskin.petclinic.pet.entity.Pet;
import ru.aveskin.petclinic.pet.mapper.PetRequestCreateToPetMapper;
import ru.aveskin.petclinic.pet.mapper.PetRequestUpdateToPetMapper;
import ru.aveskin.petclinic.pet.mapper.PetToPetResponseMapper;
import ru.aveskin.petclinic.pet.repository.PetRepository;
import ru.aveskin.petclinic.pet.service.PetService;
import ru.aveskin.petclinic.security.api.service.IdentityApiService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {
    private final IdentityApiService identityApiService;
    private final PetRepository petRepository;
    private final PetToPetResponseMapper petToPetResponseMapper;
    private final PetRequestCreateToPetMapper petRequestCreateToPetMapper;
    private final PetRequestUpdateToPetMapper petRequestUpdateToPetMapper;

    @Override
    @Transactional(readOnly = true)
    public List<PetResponseDto> findPetsByOwner(Long ownerId) {
        return petRepository.findByOwnerId(ownerId)
                .stream()
                .map(petToPetResponseMapper::map)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PetResponseDto> findPetsForCurrentOwner() {
        long ownerId = identityApiService.getCurrentOwnerId();

        return petRepository.findByOwnerId(ownerId)
                .stream()
                .map(petToPetResponseMapper::map)
                .toList();
    }

    @Override
    @Transactional
    public void create(CreatePetRequestDto request) {
        long ownerId = identityApiService.getCurrentOwnerId();

        if (!petRepository.existsByOwnerId(ownerId)) {
            throw new IllegalArgumentException("Owner with this id not exists");
        }
        request.setOwnerId(ownerId);
        petRepository.save(petRequestCreateToPetMapper.map(request));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        checkPetAvailability(id);
        petRepository.deleteById(id);
    }

    @Override
    public ChangePetResponseDto update(Long id, ChangePetRequestDto request) {
        checkPetAvailability(id);

        request.setId(id);
        Pet changedPet = petRequestUpdateToPetMapper.map(request);
        petRepository.save(changedPet);


        return new ChangePetResponseDto(changedPet.getName(),
                changedPet.getBirthDate(),
                changedPet.getSpecies(),
                changedPet.getBreed(),
                changedPet.getOwner().getId());
    }

    private void checkPetAvailability(Long id) {
        var petsOp = petRepository.findById(id);
        Pet pet = petsOp.orElseThrow(() -> new RuntimeException("Pet not found"));

        if (identityApiService.isOwner()) {
            long ownerId = identityApiService.getCurrentOwnerId();
            if (!pet.getOwner().getId().equals(ownerId)) {
                throw new IllegalArgumentException("Pet does not belong to the Owner");
            }
        }
    }


}
