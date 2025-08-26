package ru.aveskin.petclinic.security.service;

import ru.aveskin.petclinic.security.model.Roles;
import ru.aveskin.petclinic.security.model.UserRole;

import java.util.Optional;

public interface UserRoleService {
    Optional<UserRole> findUserRole(Roles role);
}