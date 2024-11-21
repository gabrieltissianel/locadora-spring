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

import com.locadora.application.TituloApplication;
import com.locadora.model.Titulo;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/titulos")
@AllArgsConstructor
public class TituloController {

    private final TituloApplication tituloApplication;

    @GetMapping("/list")
    public ResponseEntity<List<Titulo>> list() {
        return tituloApplication.list();
    }

    @PostMapping("/add")
    public ResponseEntity<Titulo> add(@Valid @RequestBody Titulo titulo) {
        return tituloApplication.add(titulo);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        tituloApplication.remove(id);
    }

    @PostMapping("/edit")
    public ResponseEntity<Titulo> edit(@Valid @RequestBody Titulo titulo) {
        return tituloApplication.update(titulo);
    }
}
