package ru.aveskin.petclinic.owner.repository;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.aveskin.petclinic.owner.entity.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    boolean existsByEmail(String email);
}