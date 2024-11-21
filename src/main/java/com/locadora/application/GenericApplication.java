package com.locadora.application;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public abstract class GenericApplication<E extends Object> {

    protected final JpaRepository<E, Long> objRepository;

    public List<E> list() {
        return objRepository.findAll();
    }

    public E add(E obj) {
        try {
            objRepository.save(obj);
            return obj;
        } catch (Exception e) {
            return null;
        }
    }

    public void remove(long id) {
        objRepository.deleteById(id);
    }

    public E update(E obj) {
        try {
            objRepository.save(obj);
            return obj;
        } catch (Exception e) {
            return null;
        }
    }
}
