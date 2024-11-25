package com.locadora.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.application.GenericApplication;
import com.locadora.model.Ator;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Controlador para gerenciar os atores.
 * Esta classe expõe os endpoints para as operações CRUD da entidade Ator.
 */
@Tag(name = "Atores", description = "Endpoints para gerenciar os atores no sistema")
@RestController
@RequestMapping("/atores")
public class AtoresController extends GenericController<Ator> {

    /**
     * Construtor do controlador de Atores.
     * @param genericApplication Instância do serviço de Atores (GenericApplication).
     */
    public AtoresController(GenericApplication<Ator> genericApplication){
        super(genericApplication);
    }
}
