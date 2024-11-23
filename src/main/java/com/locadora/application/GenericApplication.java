package com.locadora.application;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.locadora.model.Identity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GenericApplication<E extends Identity> {

    protected final JpaRepository<E, Long> objRepository;

    private final Class classe;

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
        return ResponseEntity.ok().body(classe.getSimpleName() + " excluido com sucesso"); 
    }

    public ResponseEntity<E> update(E obj) {
        objRepository.findById(obj.getId()).orElseThrow(()-> new RuntimeException(classe.getSimpleName() + " não encontrado para edição."));
        objRepository.save(obj);
        return ResponseEntity.ok().body(obj);
    }
}
