package ru.aveskin.petclinic.vet.mapper;

import ru.aveskin.petclinic.security.mapper.Mapper;
import ru.aveskin.petclinic.vet.dto.VetResponseDto;
import ru.aveskin.petclinic.vet.entity.Vet;

public interface VetToVetResponseMapper extends Mapper<VetResponseDto,Vet> {
}
