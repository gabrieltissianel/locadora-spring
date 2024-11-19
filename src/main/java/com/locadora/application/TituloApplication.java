package com.locadora.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.locadora.dto.TituloDTO;
import com.locadora.mapper.TituloMapper;
import com.locadora.model.Titulo;

@Service
public class TituloApplication extends GenericApplication<Titulo, TituloDTO>{

    public TituloApplication(JpaRepository<Titulo, Long> repository, TituloMapper tituloMapper){
        super(repository);
        this.tituloMapper = tituloMapper;
    }

    private TituloMapper tituloMapper;

    @Override
    protected Titulo toEntity(TituloDTO objDTO){
        return tituloMapper.toEntity(objDTO);
    }

    @Override
    protected TituloDTO toDTO(Titulo obj) {
        return tituloMapper.toDTO(obj);
    }

}
