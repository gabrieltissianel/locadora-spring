package com.locadora.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.locadora.application.GenericApplication;
import com.locadora.model.Identity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GenericController<E extends Identity> {

    private final GenericApplication<E> genericApplication;

    @GetMapping("/list")
    public ResponseEntity<List<E>> list() {
        return genericApplication.list();
    }


}
