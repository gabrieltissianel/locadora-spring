package com.locadora.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.application.GenericApplication;
import com.locadora.model.Titulo;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Controlador para gerenciar títulos.
 * Esta classe expõe os endpoints para as operações CRUD da entidade Titulo.
 */
@Tag(name = "Títulos", description = "Endpoints para gerenciar os títulos no sistema")
@RestController
@RequestMapping("/titulos")
public class TituloController extends GenericController<Titulo> {

    /**
     * Construtor do controlador de Títulos.
     * @param genericApplication Instância do serviço de Títulos (GenericApplication).
     */
    public TituloController(GenericApplication<Titulo> genericApplication){
        super(genericApplication);
    }
}
