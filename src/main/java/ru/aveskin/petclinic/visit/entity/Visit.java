package ru.aveskin.petclinic.visit.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.aveskin.petclinic.billing.entity.Bill;
import ru.aveskin.petclinic.pet.entity.Pet;
import ru.aveskin.petclinic.vet.entity.Vet;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "visits", schema = "pet_clinic")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "visit_date", nullable = false)
    private LocalDateTime visitDate;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "vet_id", nullable = false)
    private Vet vet;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToOne(mappedBy = "visit", cascade = CascadeType.ALL, orphanRemoval = true)
    private Bill bill;

}