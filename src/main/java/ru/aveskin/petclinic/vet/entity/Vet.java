package ru.aveskin.petclinic.vet.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.aveskin.petclinic.visit.entity.Visit;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "vets", schema = "pet_clinic")
public class Vet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    private String specialization;

    private String phone;

    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "vet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Visit> visits;

}