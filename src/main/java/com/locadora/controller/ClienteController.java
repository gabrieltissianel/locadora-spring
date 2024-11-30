package com.locadora.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.application.GenericApplication;
import com.locadora.model.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends GenericController<Cliente>{
    
    public ClienteController(GenericApplication<Cliente> application){
        super(application);
    }
    
}
