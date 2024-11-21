package com.locadora.application;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.locadora.model.Identity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class GenericApplication<E extends Identity> {

    protected final JpaRepository<E, Long> objRepository;

    public ResponseEntity<List<E>> list() {
        return ResponseEntity.ok().body(objRepository.findAll());
    }

    public ResponseEntity<E> add(E obj) {
        objRepository.save(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    public ResponseEntity<String> remove(long id) {
        objRepository.findById(id).orElseThrow(()-> new RuntimeException("Objeto não encontrado."));
        objRepository.deleteById(id);
        return ResponseEntity.ok().body("Registro Excluido com sucesso"); 
    }

    public ResponseEntity<E> update(E obj) {
        objRepository.findById(obj.getId()).orElseThrow(()-> new RuntimeException("Objeto não encontrado."));
        objRepository.save(obj);
        return ResponseEntity.ok().body(obj);
    }
}
