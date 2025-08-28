package ru.aveskin.petclinic.pet.controller;

/*

GET /api/pets/{id}/visits – визиты питомца
 */


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.aveskin.petclinic.pet.dto.ChangePetRequestDto;
import ru.aveskin.petclinic.pet.dto.ChangePetResponseDto;
import ru.aveskin.petclinic.pet.dto.CreatePetRequestDto;
import ru.aveskin.petclinic.pet.dto.PetResponseDto;
import ru.aveskin.petclinic.pet.service.PetService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pets")
@RequiredArgsConstructor
@Slf4j
public class PetController {
    private final PetService petService;

    @GetMapping("/my")
    @ResponseStatus(HttpStatus.OK)
    public List<PetResponseDto> getMyPets() {
        log.info("Getting PETS for current owner");
        return petService.findPetsForCurrentOwner();
    }

    @GetMapping("/by-owner/{ownerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<PetResponseDto> getPetsByOwner(@PathVariable Long ownerId) {
        log.info("Getting PETS for ADMIN by ownerId: {}", ownerId);
        return petService.findPetsByOwner(ownerId);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPet(@RequestBody @Valid CreatePetRequestDto request) {
        log.info("Creating PET for current owner: {}", request);
        petService.create(request);
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deletePet(@PathVariable Long id) {
        petService.delete(id);
    }

    @PutMapping("edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ChangePetResponseDto updatePet(@PathVariable Long id,
                                          @RequestBody @Valid ChangePetRequestDto request) {
        return petService.update(id, request);
    }


}
