package com.locadora.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.application.ClienteApplication;
import com.locadora.application.GenericApplication;
import com.locadora.model.Cliente;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/clientes")
public class ClienteController extends GenericController<Cliente>{
    
    public ClienteController(GenericApplication<Cliente> application){
        super(application);
    }
    
    @PostMapping("/trocarEstado")
    public ResponseEntity<Cliente> trocarEstadoDoCliente(@Valid @RequestBody Cliente entity) {
        return ResponseEntity.ok().body( ((ClienteApplication) genericApplication).trocarEstadoDoCliente(entity) );
    }
    
}
