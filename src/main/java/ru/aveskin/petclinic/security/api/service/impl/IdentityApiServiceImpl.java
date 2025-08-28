package ru.aveskin.petclinic.security.api.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.aveskin.petclinic.security.api.model.CurrentUserApiModel;
import ru.aveskin.petclinic.security.api.service.IdentityApiService;
import ru.aveskin.petclinic.security.model.UserRole;
import ru.aveskin.petclinic.security.service.UserAccountService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IdentityApiServiceImpl implements IdentityApiService {
    private final UserAccountService service;

    @Override
    public Optional<CurrentUserApiModel> currentUserAccount() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        if (authentication == null) {
            return Optional.empty();
        }
        String username = authentication.getName();

        return service.findUserByUsername(username)
                .map(userAccount -> new CurrentUserApiModel(userAccount.getId(),
                        userAccount.getAuthorities()));
    }

    @Override
    public long getCurrentOwnerId() {
        var currentUserOp = currentUserAccount();
        var currentUser = currentUserOp.orElseThrow(() -> new RuntimeException("Authenticated user not found"));
        return currentUser.userAccountId();
    }

    @Override
    public boolean isAdmin() {
        var currentUser = currentUserAccount()
                .orElseThrow(() -> new RuntimeException("Authenticated user not found"));

        return currentUser.userRoles()
                .stream()
                .map(UserRole::getAuthority) //
                .anyMatch(role -> role.equals("ROLE_ADMIN"));
    }

    @Override
    public boolean isOwner() {
        var currentUser = currentUserAccount()
                .orElseThrow(() -> new RuntimeException("Authenticated user not found"));

        return currentUser.userRoles()
                .stream()
                .map(UserRole::getAuthority) //
                .anyMatch(role -> role.equals("ROLE_OWNER"));
    }
}
