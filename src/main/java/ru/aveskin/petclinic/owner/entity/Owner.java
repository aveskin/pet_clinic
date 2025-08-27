package ru.aveskin.petclinic.owner.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import ru.aveskin.petclinic.pet.entity.Pet;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "owners", schema = "pet_clinic")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pet> pets;

}