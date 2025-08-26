package ru.aveskin.petclinic.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aveskin.petclinic.security.model.Roles;
import ru.aveskin.petclinic.security.model.UserRole;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    Optional<UserRole> findByAuthority(String authority);
}