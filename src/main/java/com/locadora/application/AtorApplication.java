package com.locadora.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.locadora.dto.AtorDTO;
import com.locadora.mapper.AtorMapper;
import com.locadora.model.Ator;

@Service
public class AtorApplication extends GenericApplication<Ator, AtorDTO> {

    public AtorApplication(JpaRepository<Ator, Long> repository, AtorMapper atorMapper){
        super(repository);
        this.atorMapper = atorMapper;
    }

    private AtorMapper atorMapper;

    @Override
    protected Ator toEntity(AtorDTO objDTO){
        return atorMapper.toEntity(objDTO);
    }

    @Override
    protected AtorDTO toDTO(Ator obj) {
        return atorMapper.toDTO(obj);
    }
}
