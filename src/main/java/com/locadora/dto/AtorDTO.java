package com.locadora.dto;

import java.util.List;

import com.locadora.model.Titulo;

public record AtorDTO(long id, String name, List<Titulo> titulos) implements Identity {
    @Override
    public long getID() {
        return id;
    }
}
