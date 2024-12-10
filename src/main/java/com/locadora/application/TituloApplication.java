package com.locadora.application;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.locadora.model.Titulo;
import com.locadora.repository.TituloRepository;

@Service
public class TituloApplication extends GenericApplication<Titulo>{

    public TituloApplication(JpaRepository<Titulo, Long> repository){
        super(repository, Titulo.class);
    }

    public List<Titulo> pesquisarPorNome(String nome){
        return ((TituloRepository) objRepository).findByNomeContainingIgnoreCase(nome);
    }

    public List<Titulo> pesquisarPorClasse(String classe){
        return ((TituloRepository) objRepository).findByClasse_NameContainingIgnoreCase(classe);
    }

    public List<Titulo> pesquisarPorAtor(String ator){
        return ((TituloRepository) objRepository).findByAtor_NameContainingIgnoreCase(ator);
    }

}
