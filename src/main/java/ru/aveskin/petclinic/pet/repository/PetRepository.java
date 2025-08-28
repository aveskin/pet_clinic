package ru.aveskin.petclinic.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aveskin.petclinic.pet.entity.Pet;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByOwnerId(Long ownerId);

    boolean existsByOwnerId(long ownerId);
}