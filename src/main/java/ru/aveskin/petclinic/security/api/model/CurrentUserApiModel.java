package ru.aveskin.petclinic.security.api.model;

import ru.aveskin.petclinic.security.model.Roles;
import ru.aveskin.petclinic.security.model.UserRole;

import java.util.List;

public record CurrentUserApiModel(long userAccountId, List<UserRole> userRoles) {
}
