package com.locadora.application;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.locadora.exception.NotFoundException;
import com.locadora.model.Identity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GenericApplication<E extends Identity> {

    protected final JpaRepository<E, Long> objRepository;

    private final Class<E> classe;

    public ResponseEntity<List<E>> list() {
        return ResponseEntity.ok().body(objRepository.findAll());
    }

    public ResponseEntity<E> add(E obj) {
        objRepository.save(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    public ResponseEntity<String> remove(long id) {
        objRepository.findById(id).orElseThrow(()-> new NotFoundException(classe.getSimpleName()));
        objRepository.deleteById(id);        
        return ResponseEntity.ok().body(classe.getSimpleName() + " excluido com sucesso"); 
    }

    public ResponseEntity<E> update(E obj) {
        objRepository.findById(obj.getId()).orElseThrow(()-> new NotFoundException(classe.getSimpleName()));
        objRepository.save(obj);
        return ResponseEntity.ok().body(obj);
    }
}
