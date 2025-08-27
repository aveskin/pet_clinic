package ru.aveskin.petclinic.vet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aveskin.petclinic.vet.entity.Vet;

public interface VetRepository extends JpaRepository<Vet, Long> {
}