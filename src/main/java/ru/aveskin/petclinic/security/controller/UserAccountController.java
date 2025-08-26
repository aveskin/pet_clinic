package ru.aveskin.petclinic.security.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.aveskin.petclinic.security.dto.RegisterRequest;
import ru.aveskin.petclinic.security.mapper.RegisterRequestToUserAccountMapper;
import ru.aveskin.petclinic.security.service.UserAccountService;


@Slf4j
@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class UserAccountController {
    private final UserAccountService userAccountService;
    private final RegisterRequestToUserAccountMapper mapper;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@Valid @RequestBody RegisterRequest request) {
        log.info("register request: {}", request);
        userAccountService.createUserAccount(mapper.map(request));
    }
}