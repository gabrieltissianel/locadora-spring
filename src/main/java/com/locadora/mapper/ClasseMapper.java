package com.locadora.mapper;

import org.mapstruct.Mapper;

import com.locadora.dto.ClasseDTO;
import com.locadora.model.Classe;

@Mapper(componentModel = "spring")
public interface ClasseMapper {
    ClasseDTO toDTO(Classe classe);
    Classe toEntity(ClasseDTO classe);
}
