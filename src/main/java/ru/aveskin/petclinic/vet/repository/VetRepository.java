package ru.aveskin.petclinic.vet.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.aveskin.petclinic.vet.entity.Vet;

import java.util.Optional;

public interface VetRepository extends JpaRepository<Vet, Long> {
    boolean existsByEmail(String email);


    @Query("SELECT v FROM Vet v LEFT JOIN FETCH v.visits WHERE v.id = :id")
    Optional<Vet> findVetWithVisitsById(@Param("id") Long id);
}