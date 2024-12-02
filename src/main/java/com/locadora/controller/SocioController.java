package com.locadora.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.application.GenericApplication;
import com.locadora.application.SocioApplication;
import com.locadora.model.Socio;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/socios")
public class SocioController extends GenericController<Socio> {
    
    public SocioController(GenericApplication<Socio> application){
        super(application);
    }

    @PostMapping("/trocarEstado")
    public ResponseEntity<Socio> trocarEstado(@RequestBody Socio entity) {
        return ((SocioApplication) genericApplication).trocarEstadoDoSocio(entity);
    }
    
}
