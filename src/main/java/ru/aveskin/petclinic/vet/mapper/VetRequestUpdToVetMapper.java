package ru.aveskin.petclinic.vet.mapper;


import ru.aveskin.petclinic.vet.dto.ChangeVetRequestDto;
import ru.aveskin.petclinic.vet.entity.Vet;


public interface VetRequestUpdToVetMapper{
    Vet map(ChangeVetRequestDto changeVetRequestDto, Vet vet);
}
