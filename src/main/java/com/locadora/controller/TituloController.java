package com.locadora.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.application.GenericApplication;
import com.locadora.application.TituloApplication;
import com.locadora.model.Titulo;

@RestController
@RequestMapping("/titulos")
public class TituloController extends GenericController<Titulo>{

    public TituloController(GenericApplication<Titulo> genericApplication){
        super(genericApplication);
    }

    @GetMapping("/pesquisar")
    public ResponseEntity<List<Titulo>> pesquisar(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String classe,
            @RequestParam(required = false) String ator) {

        if (nome != null) {
            return ResponseEntity.ok(((TituloApplication)genericApplication).pesquisarPorNome(nome));
        } else if (classe != null) {
            return ResponseEntity.ok(((TituloApplication)genericApplication).pesquisarPorClasse(classe));
        } else if (ator != null) {
            return ResponseEntity.ok(((TituloApplication)genericApplication).pesquisarPorAtor(ator));
        }

        return ResponseEntity.badRequest().build();
    }
}
