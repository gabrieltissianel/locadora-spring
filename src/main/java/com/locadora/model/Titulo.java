package com.locadora.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Titulo implements Identity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Nome nulo")
    @NotEmpty(message = "Nome vazio")
    @Column(length = 100, nullable = false)
    private String nome;

    @Column(nullable = false)
    private int ano;

    @NotEmpty(message = "Sinopse vazia")
    private String sinopse;

    @NotEmpty(message = "Categoria vazia")
    private String categoria;

    @ManyToOne
    private Diretor diretor;

    @ManyToOne
    private Classe classe;

    @ManyToMany
    @JoinTable(
        name = "ator_titulo",
        joinColumns = @JoinColumn(name = "titulo_id"),
        inverseJoinColumns = @JoinColumn(name = "ator_id")
    )
    private List<Ator> ator;
}
