package com.locadora.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.application.TituloApplication;
import com.locadora.dto.TituloDTO;
import com.locadora.model.Titulo;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/titulos")
@AllArgsConstructor
public class TituloController {

    private final TituloApplication tituloApplication;

    @GetMapping("/list")
    public List<TituloDTO> list() {
        return tituloApplication.list();
    }

    @PostMapping("/add")
    public Titulo add(@RequestBody TituloDTO titulo) {
        return tituloApplication.add(titulo);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        tituloApplication.remove(id);
    }

    @PostMapping("/edit")
    public Titulo edit(@RequestBody TituloDTO titulo) {
        return tituloApplication.update(titulo);
    }
}
