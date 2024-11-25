package com.locadora.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.locadora.model.Item;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Serviço para gerenciamento de itens.
 * Este serviço oferece operações básicas de CRUD para a entidade Item.
 */
@Tag(name = "Item", description = "Endpoints para gerenciar os itens no sistema")
@Service
public class ItemApplication extends GenericApplication<Item> {

    /**
     * Construtor do serviço de Item.
     * @param repository Repositório JPA para a entidade Item.
     */
    public ItemApplication(JpaRepository<Item, Long> repository){
        super(repository, Item.class);
    }
}
