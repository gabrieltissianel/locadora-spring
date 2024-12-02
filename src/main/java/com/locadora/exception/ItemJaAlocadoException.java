package com.locadora.exception;

import com.locadora.model.Locacao;

public class ItemJaAlocadoException extends RuntimeException{
    
    public ItemJaAlocadoException(Locacao locacao){

        super("Item " + locacao.getItem().getNumSerie() + " já se encontra alocado.\n"
         + "Previsão de disponibilidade: " + locacao.getDtDevolucaoPrevista() );
    }
}
