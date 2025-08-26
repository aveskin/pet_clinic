package ru.aveskin.petclinic.security.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.aveskin.petclinic.security.dto.RegisterRequest;
import ru.aveskin.petclinic.security.mapper.RegisterRequestToUserAccountMapper;
import ru.aveskin.petclinic.security.model.UserAccount;
import ru.aveskin.petclinic.security.model.UserRole;
import ru.aveskin.petclinic.security.service.AvailableUserRoleChecker;
import ru.aveskin.petclinic.security.service.UserRoleService;

import java.util.List;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class RegisterRequestToUserAccountMapperImpl implements RegisterRequestToUserAccountMapper {

    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;
    private final AvailableUserRoleChecker availableUserRoleChecker;

    @Override
    public UserAccount map(RegisterRequest request) {
        availableUserRoleChecker.check(request);

        UserRole userRole = userRoleService
                .findUserRole(request.role())
                .orElseThrow(() -> new RuntimeException("User role not found"));

        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(request.username().toLowerCase(Locale.ROOT));
        userAccount.setPassword(passwordEncoder.encode(request.password()));
        userAccount.setAuthorities(List.of(userRole));
        return userAccount;
    }
}