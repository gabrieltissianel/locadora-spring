package com.locadora.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.model.Locacao;

public interface LocadoraRepository extends JpaRepository<Locacao, Long>{
    List<Locacao> findByDtDevolucaoEfetivaIsNull();
    List<Locacao> findByDtDevolucaoEfetivaIsNotNull();
    List<Locacao> findByClienteIdAndDtDevolucaoEfetivaIsNull(Long clienteId);
    List<Locacao> findByClienteId(Long clienteId);
    Optional<Locacao> findByItemNumSerieAndDtDevolucaoEfetivaIsNull(int numSerie);
}
