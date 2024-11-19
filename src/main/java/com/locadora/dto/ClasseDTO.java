package com.locadora.dto;

import java.sql.Date;
import java.util.List;

import com.locadora.model.Titulo;

public record ClasseDTO(long id, String name, double value, Date prazoDevolucao, List<Titulo> titulos) implements Identity {
    @Override
    public long getID() {
        return id;
    }
}
