package com.locadora.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.locadora.dto.ItemDTO;
import com.locadora.mapper.ItemMapper;
import com.locadora.model.Item;

@Service
public class ItemApplication extends GenericApplication<Item, ItemDTO>{

    public ItemApplication(JpaRepository<Item, Long> repository, ItemMapper itemMapper){
        super(repository);
        this.itemMapper = itemMapper;
    }
    
    private ItemMapper itemMapper;

    @Override
    protected Item toEntity(ItemDTO objDTO){
        return itemMapper.toEntity(objDTO);
    }

    @Override
    protected ItemDTO toDTO(Item obj) {
        return itemMapper.toDTO(obj);
    }

}
