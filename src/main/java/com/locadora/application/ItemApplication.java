package com.locadora.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.locadora.model.Item;

@Service
public class ItemApplication extends GenericApplication<Item>{

    public ItemApplication(JpaRepository<Item, Long> repository){
        super(repository, Item.class);
    }

}
