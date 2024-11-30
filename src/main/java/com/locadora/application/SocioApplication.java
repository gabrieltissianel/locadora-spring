package com.locadora.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.locadora.model.Socio;

@Service
public class SocioApplication extends GenericApplication<Socio> {
    
    public SocioApplication(JpaRepository<Socio, Long> repository){
        super(repository, Socio.class);
    }
}
