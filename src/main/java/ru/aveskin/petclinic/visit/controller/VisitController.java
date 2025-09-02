package ru.aveskin.petclinic.visit.controller;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.aveskin.petclinic.visit.dto.*;
import ru.aveskin.petclinic.visit.service.VisitService;


@RestController
@RequestMapping("/api/v1/visits")
@RequiredArgsConstructor
@Slf4j
public class VisitController {
    private final VisitService visitService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public VisitsPageResponseDto getVisits(@PathParam("page") int page,
                                           @PathParam("limit") int limit) {
        log.info("getting Visits from page: {}", page);
        VisitFindRequest visitFindRequest = new VisitFindRequest(page, limit);
        return visitService.findVisits(visitFindRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VisitResponseDto getVisit(@PathVariable Long id) {
        log.info("getting Visit by id: {}", id);
        return visitService.findVisit(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createVisit(@RequestBody @Valid CreateVisitRequestDto request) {
        log.info("creating Visit: {}", request);
        visitService.create(request);
    }

    @PutMapping("edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VisitResponseDto updateVisit(@PathVariable Long id,
                                        @RequestBody @Valid ChangeVisitRequestDto request) {
        return visitService.update(id, request);
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteVisit(@PathVariable Long id) {
        visitService.delete(id);
    }


}
