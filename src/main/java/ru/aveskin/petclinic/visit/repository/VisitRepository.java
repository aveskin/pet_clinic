package ru.aveskin.petclinic.visit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aveskin.petclinic.visit.entity.Visit;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}