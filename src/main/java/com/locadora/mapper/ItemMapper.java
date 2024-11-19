package com.locadora.mapper;

import org.mapstruct.Mapper;

import com.locadora.dto.ItemDTO;
import com.locadora.model.Item;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemDTO toDTO(Item obj);
    Item toEntity(ItemDTO dto);
}
