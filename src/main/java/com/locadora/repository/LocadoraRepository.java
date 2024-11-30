package com.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.model.Locacao;

public interface LocadoraRepository extends JpaRepository<Locacao, Long>{

}
