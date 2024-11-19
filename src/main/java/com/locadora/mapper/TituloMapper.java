package com.locadora.mapper;

import org.mapstruct.Mapper;

import com.locadora.dto.TituloDTO;
import com.locadora.model.Titulo;

@Mapper(componentModel = "spring")
public interface TituloMapper {
    TituloDTO toDTO(Titulo obj);
    Titulo toEntity(TituloDTO dto);
}
