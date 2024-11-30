package com.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.model.Socio;

public interface SocioRepository extends JpaRepository<Socio, Long>{
    
}
