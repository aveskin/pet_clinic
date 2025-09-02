package ru.aveskin.petclinic.vet.mapper;

import org.springframework.data.domain.Page;
import ru.aveskin.petclinic.security.mapper.Mapper;
import ru.aveskin.petclinic.vet.dto.VetsPageResponseDto;
import ru.aveskin.petclinic.vet.entity.Vet;

public interface VetPageToVetPageResponseMapper extends Mapper<VetsPageResponseDto, Page<Vet>> {
}
