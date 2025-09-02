package ru.aveskin.petclinic.vet.mapper;


import ru.aveskin.petclinic.security.mapper.Mapper;
import ru.aveskin.petclinic.vet.dto.CreateVetRequestDto;
import ru.aveskin.petclinic.vet.entity.Vet;


public interface VetRequestCreateToVetMapper extends Mapper<Vet, CreateVetRequestDto> {
}
