package com.locadora.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.locadora.model.Diretor;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Serviço para gerenciamento de diretores.
 * Este serviço oferece operações básicas de CRUD para a entidade Diretor.
 */
@Tag(name = "Diretor", description = "Endpoints para gerenciar diretores")
@Service
public class DiretorApplication extends GenericApplication<Diretor> {

    /**
     * Construtor do serviço de Diretor.
     * @param repository Repositório JPA para a entidade Diretor.
     */
    public DiretorApplication(JpaRepository<Diretor, Long> repository){
        super(repository, Diretor.class);
    }
}
