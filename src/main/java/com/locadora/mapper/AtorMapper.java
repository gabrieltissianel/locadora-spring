package com.locadora.mapper;

import org.mapstruct.Mapper;

import com.locadora.dto.AtorDTO;
import com.locadora.model.Ator;

@Mapper(componentModel = "spring")
public interface AtorMapper {
    
    AtorDTO toDTO(Ator ator);
    Ator toEntity(AtorDTO ator);
}
