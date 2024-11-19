package com.locadora.dto;

import java.util.List;

import com.locadora.model.Ator;
import com.locadora.model.Classe;
import com.locadora.model.Diretor;
import com.locadora.model.Item;

public record TituloDTO(long id, String nome, int ano, String sinopse, String categoria, Classe classe, Diretor diretor, List<Ator> ator, List<Item> items) implements Identity{
    @Override
    public long getID() {
        return id;
    }
}
