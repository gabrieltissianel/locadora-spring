package com.locadora.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.application.GenericApplication;
import com.locadora.model.Socio;

@RestController
@RequestMapping("/socios")
public class SocioController extends GenericController<Socio> {
    
    public SocioController(GenericApplication<Socio> application){
        super(application);
    }
}
