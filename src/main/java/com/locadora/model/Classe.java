package com.locadora.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Classe implements Identity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Nome nulo")
    @NotEmpty(message = "Nome vazio")
    @Column(length = 100, nullable = false)
    private String name;

    @NotNull(message = "Valor nulo")
    @Min(value = 0, message = "Valor menor que 0")
    private double value;

    @NotNull(message = "Prazo nulo")
    @Min(value = 0)
    private int prazoDevolucao;
}
