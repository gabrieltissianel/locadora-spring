package com.locadora.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.locadora.model.Dependente;
import com.locadora.model.Socio;
import com.locadora.repository.DependenteRepository;

@Service
public class SocioApplication extends GenericApplication<Socio> {
    
    @Autowired
    DependenteRepository dependenteRepository;

    public SocioApplication(JpaRepository<Socio, Long> repository){
        super(repository, Socio.class);
    }

    public ResponseEntity<Socio> trocarEstadoDoSocio(Socio cliente){
        if (cliente.isEstahAtivo()) {
            
            List<Dependente> dependentes = dependenteRepository.findBySocioId(cliente.getId());
            for (Dependente dep: dependentes){
                dep.setEstahAtivo(false);
            }
            cliente.setEstahAtivo(false);
            
        } else {
            cliente.setEstahAtivo(true);
        }

        objRepository.save(cliente);
        return ResponseEntity.ok().body(cliente);
    }
}
