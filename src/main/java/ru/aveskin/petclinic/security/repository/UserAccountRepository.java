package ru.aveskin.petclinic.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aveskin.petclinic.security.model.UserAccount;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    boolean existsByUsername(String username);

    Optional<UserAccount> findByUsername(String username);

}