package com.locadora.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Socio extends Cliente{
    
    private String cpf;

    private String endereco;

    private String tel;
}
