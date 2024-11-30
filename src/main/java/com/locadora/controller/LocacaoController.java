package com.locadora.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.application.GenericApplication;
import com.locadora.model.Locacao;

@RestController
@RequestMapping("/locacoes")
public class LocacaoController extends GenericController<Locacao>{

    public LocacaoController(GenericApplication<Locacao> application){
        super(application);
    }

}
