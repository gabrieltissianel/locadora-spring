package com.locadora.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.locadora.dto.DiretorDTO;
import com.locadora.mapper.DiretorMapper;
import com.locadora.model.Diretor;


@Service
public class DiretorApplication extends GenericApplication<Diretor, DiretorDTO> {

    private DiretorMapper diretorMapper;

    public DiretorApplication(JpaRepository<Diretor, Long> repository, DiretorMapper diretorMapper){
        super(repository);
        this.diretorMapper = diretorMapper;
    }

    @Override
    protected Diretor toEntity(DiretorDTO objDTO) {
        return diretorMapper.toEntity(objDTO);
    }

    @Override
    protected DiretorDTO toDTO(Diretor obj) {
        return diretorMapper.toDTO(obj);
    }
}
