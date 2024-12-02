package com.locadora.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.application.GenericApplication;
import com.locadora.application.LocacaoApplication;
import com.locadora.model.Locacao;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/locacoes")
public class LocacaoController extends GenericController<Locacao>{

    public LocacaoController(GenericApplication<Locacao> application){
        super(application);
    }

    @GetMapping("/buscar/{itemSerie}")
    public ResponseEntity<Locacao> buscarLocacao(@PathVariable int itemSerie){
        return ((LocacaoApplication) genericApplication).buscarLocacao(itemSerie);
    }

    @PostMapping("/devolver")
    public ResponseEntity<Locacao> devolverLocacao(@RequestBody Locacao obj) {
        return ((LocacaoApplication) genericApplication).devolverLocacao(obj);
    }

}
