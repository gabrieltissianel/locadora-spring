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

import com.locadora.application.DiretorApplication;
import com.locadora.model.Diretor;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/diretores")
@AllArgsConstructor
public class DiretorControler {

    private final DiretorApplication diretorApplication;

    @GetMapping("/list")
    public ResponseEntity<List<Diretor>> list() {
        return diretorApplication.list();
    }

    @PostMapping("/add")
    public ResponseEntity<Diretor> add(@Valid @RequestBody Diretor diretor) {
        return diretorApplication.add(diretor);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        diretorApplication.remove(id);
    }

    @PostMapping("/edit")
    public ResponseEntity<Diretor> edit(@Valid @RequestBody Diretor diretor) {
        return diretorApplication.update(diretor);
    }
}
