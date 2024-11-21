package com.locadora.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.application.GenericApplication;
import com.locadora.model.Titulo;

@RestController
@RequestMapping("/titulos")
public class TituloController extends GenericController<Titulo>{

    public TituloController(GenericApplication<Titulo> genericApplication){
        super(genericApplication);
    }

}
