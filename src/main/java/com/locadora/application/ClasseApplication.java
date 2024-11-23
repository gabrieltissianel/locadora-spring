package com.locadora.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.locadora.model.Classe;

@Service
public class ClasseApplication extends GenericApplication<Classe> {

    public ClasseApplication(JpaRepository<Classe, Long> repository){
        super(repository, Classe.class);
    }
}
