package com.locadora.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.locadora.application.GenericApplication;
import com.locadora.model.Identity;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GenericController<E extends Identity> {

    protected final GenericApplication<E> genericApplication;

    @GetMapping("/list")
    public ResponseEntity<List<E>> list() {
        return genericApplication.list();
    }

    @PostMapping("/add")
    public ResponseEntity<E> add(@Valid @RequestBody E obj) {
        return genericApplication.add(obj);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        genericApplication.remove(id);
    }

    @PostMapping("/edit")
    public ResponseEntity<E> edit(@Valid @RequestBody E obj) {
        return genericApplication.update(obj);
    }

}
