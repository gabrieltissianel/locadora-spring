package com.locadora.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.application.ClasseApplication;
import com.locadora.dto.ClasseDTO;
import com.locadora.model.Classe;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/classes")
@AllArgsConstructor
public class ClasseController {

    private final ClasseApplication classeApplication;

    @GetMapping("/list")
    public List<ClasseDTO> list() {
        return classeApplication.list();
    }

    @PostMapping("/add")
    public Classe add(@RequestBody ClasseDTO classe) {
        return classeApplication.add(classe);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        classeApplication.remove(id);
    }

    @PostMapping("/edit")
    public Classe edit(@RequestBody ClasseDTO classe) {
        return classeApplication.update(classe);
    }
}
