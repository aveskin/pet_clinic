package ru.aveskin.petclinic.security.service;

import ru.aveskin.petclinic.security.dto.RegisterRequest;

public interface AvailableUserRoleChecker {
    void check(RegisterRequest request);
}
