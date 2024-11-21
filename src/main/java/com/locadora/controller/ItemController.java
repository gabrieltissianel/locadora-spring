package com.locadora.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.application.GenericApplication;
import com.locadora.model.Item;


@RestController
@RequestMapping("/itens")
public class ItemController extends GenericController<Item>{

    public ItemController(GenericApplication<Item> genericController){
        super(genericController);
    }

}
