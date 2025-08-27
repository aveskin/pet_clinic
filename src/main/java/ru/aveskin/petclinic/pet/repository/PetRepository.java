package ru.aveskin.petclinic.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aveskin.petclinic.pet.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
}