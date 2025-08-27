package ru.aveskin.petclinic.pet.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.aveskin.petclinic.owner.entity.Owner;
import ru.aveskin.petclinic.visit.entity.Visit;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pets", schema = "pet_clinic")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(nullable = false)
    private String species;

    private String breed;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Visit> visits;

}