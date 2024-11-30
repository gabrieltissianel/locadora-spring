package com.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
