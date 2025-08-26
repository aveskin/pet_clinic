package ru.aveskin.petclinic.security.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aveskin.petclinic.security.mapper.UserAccountToUserMapper;
import ru.aveskin.petclinic.security.service.UserAccountService;

@Service
@RequiredArgsConstructor
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserAccountService userAccountService;
    private final UserAccountToUserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAccountService.findUserByUsername(username)
                .map(mapper::map)
                .orElseThrow(() -> new UsernameNotFoundException("неверные учетные данные пользователя"));
    }
}