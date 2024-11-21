package com.locadora.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.application.GenericApplication;
import com.locadora.model.Diretor;

@RestController
@RequestMapping("/diretores")
public class DiretorControler extends GenericController<Diretor> {

    public DiretorControler(GenericApplication<Diretor> genericApplication){
        super(genericApplication);
    }
}
