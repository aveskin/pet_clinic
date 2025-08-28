package ru.aveskin.petclinic.security.api.service;

import ru.aveskin.petclinic.security.api.model.CurrentUserApiModel;

import java.util.Optional;

public interface IdentityApiService {
    Optional<CurrentUserApiModel> currentUserAccount();

    public long getCurrentOwnerId();

    boolean isAdmin();

    boolean isOwner();

}