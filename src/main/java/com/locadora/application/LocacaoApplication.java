package com.locadora.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.locadora.model.Locacao;

@Service
public class LocacaoApplication extends GenericApplication<Locacao>{

    public LocacaoApplication(JpaRepository<Locacao, Long> repository){
        super(repository, Locacao.class);
    }

}   
