package com.locadora.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Locacao implements Identity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private Date dtLocacao;
    
    private Date dtDevolucaoPrevista;

    private Date dtDevolucaoEfetiva;

    private double valorCobrado;

    private double multaCobrada;

    @ManyToOne
    private Item item;

    @ManyToOne
    private Cliente cliente;

}
