package com.locadora.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.application.GenericApplication;
import com.locadora.model.Diretor;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Controlador para gerenciar diretores.
 * Esta classe expõe os endpoints para as operações CRUD da entidade Diretor.
 */
@Tag(name = "Diretores", description = "Endpoints para gerenciar os diretores no sistema")
@RestController
@RequestMapping("/diretores")
public class DiretorController extends GenericController<Diretor> {

    /**
     * Construtor do controlador de Diretores.
     * @param genericApplication Instância do serviço de Diretores (GenericApplication).
     */
    public DiretorController(GenericApplication<Diretor> genericApplication){
        super(genericApplication);
    }
}
