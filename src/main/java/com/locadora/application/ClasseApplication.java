package com.locadora.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.locadora.dto.ClasseDTO;
import com.locadora.mapper.ClasseMapper;
import com.locadora.model.Classe;

@Service
public class ClasseApplication extends GenericApplication<Classe, ClasseDTO> {

    public ClasseApplication(JpaRepository<Classe, Long> repository, ClasseMapper classeMapper){
        super(repository);
        this.classeMapper = classeMapper;
    }

    private ClasseMapper classeMapper;

    @Override
    protected Classe toEntity(ClasseDTO objDTO){
        return classeMapper.toEntity(objDTO);
    }

    @Override
    protected ClasseDTO toDTO(Classe obj) {
        return classeMapper.toDTO(obj);
    }
}
