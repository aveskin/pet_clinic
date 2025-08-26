package ru.aveskin.petclinic.security.mapper;

import org.springframework.security.core.userdetails.User;
import ru.aveskin.petclinic.security.model.UserAccount;

public interface UserAccountToUserMapper extends Mapper<User, UserAccount> {
}