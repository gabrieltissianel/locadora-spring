package com.locadora.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.application.AtorApplication;
import com.locadora.model.Ator;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/atores")
@AllArgsConstructor
public class AtoresController {

    private final AtorApplication atorApplication;

    @GetMapping("/list")
    public ResponseEntity<List<Ator>> list() {
        return atorApplication.list();
    }

    @PostMapping("/add")
    public ResponseEntity<Ator> add(@Valid @RequestBody Ator ator) {
        return atorApplication.add(ator);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        atorApplication.remove(id);
    }

    @PostMapping("/edit")
    public ResponseEntity<Ator> edit(@Valid @RequestBody Ator ator) {
        return atorApplication.update(ator);
    }

}
