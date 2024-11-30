package com.locadora.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente implements Identity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @NotNull(message = "Nome nulo")
    @NotEmpty(message = "Nome vazio")
    @Column(length = 100, nullable = false)
    protected String nome;

    @NotNull(message = "Data nula")
    protected Date dtNascimento;

    @NotNull(message = "Sexo nulo.")
    protected char sexo;

    @NotNull(message = "Sexo nulo.")
    protected boolean estahAtivo;
}
