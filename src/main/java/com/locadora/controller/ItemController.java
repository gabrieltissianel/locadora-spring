package com.locadora.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.application.GenericApplication;
import com.locadora.model.Item;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Controlador para gerenciar itens.
 * Esta classe expõe os endpoints para as operações CRUD da entidade Item.
 */
@Tag(name = "Itens", description = "Endpoints para gerenciar os itens no sistema")
@RestController
@RequestMapping("/itens")
public class ItemController extends GenericController<Item> {

    /**
     * Construtor do controlador de Itens.
     * @param genericApplication Instância do serviço de Itens (GenericApplication).
     */
    public ItemController(GenericApplication<Item> genericApplication){
        super(genericApplication);
    }
}
