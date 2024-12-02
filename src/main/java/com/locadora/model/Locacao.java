package com.locadora.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Locacao implements Identity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private LocalDate dtLocacao;
    
    private LocalDate dtDevolucaoPrevista;

    private LocalDate dtDevolucaoEfetiva;

    @Min(value = 0, message = "O valor cobrado deve ser positivo.")
    private double valorCobrado;

    @Min(value = 0, message = "A multa cobrada deve possuir o valor positivo.")
    private double multaCobrada;

    @NotNull(message = "Item nulo")
    @ManyToOne
    private Item item;

    @NotNull(message = "Cliente nulo")
    @ManyToOne
    private Cliente cliente;

}
