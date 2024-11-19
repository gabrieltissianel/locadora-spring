package com.locadora.mapper;

import org.mapstruct.Mapper;

import com.locadora.dto.DiretorDTO;
import com.locadora.model.Diretor;

@Mapper(componentModel = "spring")
public interface DiretorMapper {
    DiretorDTO toDTO(Diretor obj);
    Diretor toEntity(DiretorDTO dto);
}
