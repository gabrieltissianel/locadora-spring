package com.locadora.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.application.GenericApplication;
import com.locadora.model.Classe;

@RestController
@RequestMapping("/classes")
public class ClasseController extends GenericController<Classe>{

    public ClasseController(GenericApplication<Classe> genericApplication){
        super(genericApplication);
    }
}
