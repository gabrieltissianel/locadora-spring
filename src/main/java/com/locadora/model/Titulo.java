package com.locadora.model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    private String sinopse;

    private String categoria;

    @ManyToOne
    private Diretor diretor;

    @ManyToMany
    @JoinTable(
        name = "ator_titulo",
        joinColumns = @JoinColumn(name = "titulo_id"),
        inverseJoinColumns = @JoinColumn(name = "ator_id")
    )
    private List<Ator> ator;

    @ManyToOne
    private Classe classe;
}
