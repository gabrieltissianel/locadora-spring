package com.locadora.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.locadora.model.Ator;

@Service
public class AtorApplication extends GenericApplication<Ator> {

    public AtorApplication(JpaRepository<Ator, Long> repository){
        super(repository);
    }
}
