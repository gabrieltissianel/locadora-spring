package com.locadora.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Item implements Identity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Número de série vazio.")
    @Column(unique = true, nullable = false)
    private int numSerie;

    @NotNull(message = "Data vazia")
    @Column(nullable = false)
    private Date dtAquisicao;

    @NotNull(message = "Tipo nulo")
    @NotEmpty(message = "Tipo vazio")
    @Column(length = 100, nullable = false)
    private String tipoItem;

    @NotNull(message = "Titulo nulo")
    @ManyToOne
    private Titulo titulo;
}
