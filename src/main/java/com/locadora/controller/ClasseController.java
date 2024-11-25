package com.locadora.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.application.GenericApplication;
import com.locadora.model.Classe;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Controlador para gerenciar as classes.
 * Esta classe expõe os endpoints para as operações CRUD da entidade Classe.
 */
@Tag(name = "Classe", description = "Endpoints para gerenciar as classes no sistema")
@RestController
@RequestMapping("/classes")
public class ClasseController extends GenericController<Classe> {

    /**
     * Construtor do controlador de Classes.
     * @param genericApplication Instância do serviço de Classes (GenericApplication).
     */
    public ClasseController(GenericApplication<Classe> genericApplication){
        super(genericApplication);
    }
}
