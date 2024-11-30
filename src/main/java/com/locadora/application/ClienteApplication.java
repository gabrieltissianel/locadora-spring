package com.locadora.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.locadora.model.Cliente;

@Service
public class ClienteApplication extends GenericApplication<Cliente>{
    
    public ClienteApplication(JpaRepository<Cliente, Long> repository){
        super(repository, Cliente.class);
    }
}
