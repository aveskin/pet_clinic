package ru.aveskin.petclinic.owner.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.aveskin.petclinic.owner.entity.Owner;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    boolean existsByEmail(String email);

    @Query("SELECT o FROM Owner o LEFT JOIN FETCH o.pets WHERE o.id = :id")
    Optional<Owner> findByIdWithPets(@Param("id") Long id);

    @Query("SELECT DISTINCT o FROM Owner o LEFT JOIN FETCH o.pets")
    Page<Owner> findAllWithPets(Pageable pageable);
}