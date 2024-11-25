package com.locadora.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.locadora.model.Classe;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Serviço para gerenciamento de classes.
 * Este serviço oferece operações básicas de CRUD para a entidade Classe.
 */
@Tag(name = "Classe", description = "Endpoints para gerenciar as classes de filmes")
@Service
public class ClasseApplication extends GenericApplication<Classe> {

    /**
     * Construtor do serviço de Classe.
     * @param repository Repositório JPA para a entidade Classe.
     */
    public ClasseApplication(JpaRepository<Classe, Long> repository){
        super(repository, Classe.class);
    }
}
