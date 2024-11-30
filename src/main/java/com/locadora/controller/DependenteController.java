package com.locadora.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.application.DependenteApplication;
import com.locadora.application.GenericApplication;
import com.locadora.model.Dependente;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/dependentes")
public class DependenteController extends GenericController<Dependente>{
    
    public DependenteController(GenericApplication<Dependente> application){
        super(application);
    }

    @GetMapping("/listDependentes/{id}")
    public ResponseEntity<List<Dependente>> listBySocio(@PathVariable int id) {
        return ((DependenteApplication) genericApplication).listSocioDependentes(id);
    }

}
