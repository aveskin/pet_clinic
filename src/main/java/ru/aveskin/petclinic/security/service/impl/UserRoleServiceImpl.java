package ru.aveskin.petclinic.security.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aveskin.petclinic.security.model.Roles;
import ru.aveskin.petclinic.security.model.UserRole;
import ru.aveskin.petclinic.security.repository.UserRoleRepository;
import ru.aveskin.petclinic.security.service.UserRoleService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    @Override
    public Optional<UserRole> findUserRole(Roles role) {
        String authority = "ROLE_" + role.name();
        return userRoleRepository.findByAuthority(authority);
    }
}