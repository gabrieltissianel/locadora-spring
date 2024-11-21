package com.locadora.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.locadora.model.Titulo;

@Service
public class TituloApplication extends GenericApplication<Titulo>{

    public TituloApplication(JpaRepository<Titulo, Long> repository){
        super(repository);
    }
}
