package ru.aveskin.petclinic.owner.controller;


import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.aveskin.petclinic.owner.dto.*;
import ru.aveskin.petclinic.owner.service.OwnerService;

@RestController
@RequestMapping("/api/v1/owners")
@RequiredArgsConstructor
@Slf4j
public class OwnerController {
    private final OwnerService ownerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public OwnersPageResponseDto getOwners(@PathParam("page") int page,
                                           @PathParam("limit") int limit) {
        log.info("getting OWNERS from page: {}", page);
        OwnerFindRequest ownerFindRequest = new OwnerFindRequest(page, limit);
        return ownerService.findOwners(ownerFindRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OwnerResponseDto getOwner(@PathVariable Long id) {
        log.info("getting OWNER by id: {}", id);
        return ownerService.findOwner(id);
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOwner(@RequestBody @Valid CreateOwnerRequestDto request) {
        log.info("creating OWNER by ADMIN: {}", request);
        ownerService.create(request);
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteOwner(@PathVariable Long id) {
        ownerService.delete(id);
    }

    @PutMapping("edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ChangeOwnerResponseDto updateOwner(@PathVariable Long id,
                                              @RequestBody @Valid ChangeOwnerRequestDto request) {
        return ownerService.update(id, request);
    }

}
