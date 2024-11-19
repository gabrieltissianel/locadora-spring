package com.locadora.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.application.DiretorApplication;
import com.locadora.dto.DiretorDTO;
import com.locadora.model.Diretor;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/diretores")
@AllArgsConstructor
public class DiretorControler {

    private final DiretorApplication diretorApplication;

    @GetMapping("/list")
    public List<DiretorDTO> list() {
        return diretorApplication.list();
    }

    @PostMapping("/add")
    public Diretor add(@RequestBody DiretorDTO diretor) {
        return diretorApplication.add(diretor);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        diretorApplication.remove(id);
    }

    @PostMapping("/edit")
    public Diretor edit(@RequestBody DiretorDTO diretor) {
        return diretorApplication.update(diretor);
    }
}
