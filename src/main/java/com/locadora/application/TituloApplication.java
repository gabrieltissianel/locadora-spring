package com.locadora.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.locadora.model.Titulo;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Serviço para gerenciamento de títulos.
 * Este serviço oferece operações básicas de CRUD para a entidade Titulo.
 */
@Tag(name = "Titulo", description = "Endpoints para gerenciar os títulos no sistema")
@Service
public class TituloApplication extends GenericApplication<Titulo> {

    /**
     * Construtor do serviço de Titulo.
     * @param repository Repositório JPA para a entidade Titulo.
     */
    public TituloApplication(JpaRepository<Titulo, Long> repository){
        super(repository, Titulo.class);
    }
}
