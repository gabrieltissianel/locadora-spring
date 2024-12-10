package com.locadora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.model.Titulo;

public interface TituloRepository extends JpaRepository<Titulo, Long>{

    List<Titulo> findByNomeContainingIgnoreCase(String nome);

    List<Titulo> findByClasse_NameContainingIgnoreCase(String classeNome);

    List<Titulo> findByAtor_NameContainingIgnoreCase(String atorNome);
}
