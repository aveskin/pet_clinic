package ru.aveskin.petclinic.security.mapper;


import ru.aveskin.petclinic.security.dto.RegisterRequest;
import ru.aveskin.petclinic.security.model.UserAccount;

public interface RegisterRequestToUserAccountMapper extends Mapper<UserAccount, RegisterRequest> {
}