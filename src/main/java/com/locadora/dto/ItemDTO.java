package com.locadora.dto;

import java.sql.Date;

import com.locadora.model.Titulo;

public record ItemDTO(long id, int numSerie, Date dtAquisicao, String tipoItem, Titulo titulo) implements Identity {

    @Override
    public long getID() {
        return id;
    }
}
