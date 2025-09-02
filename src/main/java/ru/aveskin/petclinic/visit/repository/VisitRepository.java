package ru.aveskin.petclinic.visit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.aveskin.petclinic.visit.entity.Visit;

import java.util.Optional;

public interface VisitRepository extends JpaRepository<Visit, Long> {
    @Query("""
    select v from Visit v
    left join fetch v.pet
    left join fetch v.vet
    left join fetch v.bill
    where v.id = :id
""")
    Optional<Visit> findVisitWithRelationsById(@Param("id") Long id);
}