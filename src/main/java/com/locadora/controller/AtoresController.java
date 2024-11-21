package com.locadora.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.application.GenericApplication;
import com.locadora.model.Ator;

@RestController
@RequestMapping("/atores")
public class AtoresController extends GenericController<Ator> {

    public AtoresController(GenericApplication<Ator> genericApplication){
        super(genericApplication);
    }

}
