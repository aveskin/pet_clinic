package ru.aveskin.petclinic.vet.controller;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.aveskin.petclinic.vet.dto.*;
import ru.aveskin.petclinic.vet.service.VetService;


@RestController
@RequestMapping("/api/v1/vets")
@RequiredArgsConstructor
@Slf4j
public class VetController {
    private final VetService vetService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public VetsPageResponseDto getVets(@PathParam("page") int page,
                                       @PathParam("limit") int limit) {
        log.info("getting Vets from page: {}", page);
        VetFindRequest vetFindRequest = new VetFindRequest(page, limit);
        return vetService.findVets(vetFindRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VetResponseDto getVet(@PathVariable Long id) {
        log.info("getting Vet by id: {}", id);
        return vetService.findVet(id);
    }

    @GetMapping("/{id}/visits")
    @ResponseStatus(HttpStatus.OK)
    public VetVisitsResponseDto getVetWithVisits(@PathVariable Long id) {
        log.info("getting Vet with visits by id: {}", id);
        return vetService.findVetWithVisits(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createVet(@RequestBody @Valid CreateVetRequestDto request) {
        log.info("creating Vet by ADMIN: {}", request);
        vetService.create(request);
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteVet(@PathVariable Long id) {
        vetService.delete(id);
    }

    @PutMapping("edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VetResponseDto updateVet(@PathVariable Long id,
                                    @RequestBody @Valid ChangeVetRequestDto request) {
        return vetService.update(id, request);
    }


}
