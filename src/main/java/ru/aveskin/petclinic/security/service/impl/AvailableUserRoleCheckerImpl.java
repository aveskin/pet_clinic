package ru.aveskin.petclinic.security.service.impl;

import org.springframework.stereotype.Service;
import ru.aveskin.petclinic.security.dto.RegisterRequest;
import ru.aveskin.petclinic.security.model.Roles;
import ru.aveskin.petclinic.security.service.AvailableUserRoleChecker;

import java.util.EnumSet;
import java.util.Set;

@Service
public class AvailableUserRoleCheckerImpl implements AvailableUserRoleChecker {
    @Override
    public void check(RegisterRequest request) {
        Roles role = request.role();

        if ((role.equals(Roles.ADMIN))) {
            throw new RuntimeException("Cannot register as admin");
        }

        //проверка допустимых ролей
        Set<Roles> allowedRoles = EnumSet.of(Roles.VET, Roles.OWNER);

        if (!allowedRoles.contains(role)) {
            throw new RuntimeException("Invalid role, not found");
        }
    }
}
