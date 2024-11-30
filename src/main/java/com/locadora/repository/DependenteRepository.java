package com.locadora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.model.Dependente;

public interface DependenteRepository extends JpaRepository<Dependente, Long>{
    
    List<Dependente> findBySocioId(Long socioId);
}
