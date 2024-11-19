package com.locadora.application;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.locadora.dto.Identity;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public abstract class GenericApplication<E extends Object, D extends Identity> {

    protected final JpaRepository<E, Long> objRepository;

    public List<D> list() {
        return objRepository.findAll().stream()
                .map(this::toDTO).toList();
    }

    public E add(D dto) {
        try {
            E obj = toEntity(dto);
            objRepository.save(obj);
            return obj;
        } catch (Exception e) {
            return null;
        }
    }

    public void remove(long id) {
        objRepository.deleteById(id);
    }

    public E update(D dto) {
        try {
            E obj = toEntity(dto);
            objRepository.save(obj);
            return obj;
        } catch (Exception e) {
            return null;
        }
    }

    protected abstract E toEntity(D objDTO);

    protected abstract D toDTO(E obj);
}
