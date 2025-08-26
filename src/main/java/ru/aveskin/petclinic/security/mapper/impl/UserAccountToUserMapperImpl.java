package ru.aveskin.petclinic.security.mapper.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import ru.aveskin.petclinic.security.mapper.UserAccountToUserMapper;
import ru.aveskin.petclinic.security.model.UserAccount;

@Component
public class UserAccountToUserMapperImpl implements UserAccountToUserMapper {
    @Override
    public User map(UserAccount userAccount) {
        return new User(
                userAccount.getUsername(),
                userAccount.getPassword(),
                userAccount.getAuthorities());
    }
}