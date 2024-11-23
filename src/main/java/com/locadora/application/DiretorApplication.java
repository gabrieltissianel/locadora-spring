package com.locadora.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.locadora.model.Diretor;

@Service
public class DiretorApplication extends GenericApplication<Diretor> {

    public DiretorApplication(JpaRepository<Diretor, Long> repository){
        super(repository, Diretor.class);
    }
}
