package com.locadora.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.locadora.model.Ator;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Serviço para gerenciamento de atores.
 * Este serviço oferece operações básicas de CRUD para a entidade Ator.
 */
@Tag(name = "Ator", description = "Endpoints para gerenciar os atores no sistema")
@Service
public class AtorApplication extends GenericApplication<Ator> {

    /**
     * Construtor do serviço de Ator.
     * @param repository Repositório JPA para a entidade Ator.
     */
    public AtorApplication(JpaRepository<Ator, Long> repository){
        super(repository, Ator.class);
    }
}
