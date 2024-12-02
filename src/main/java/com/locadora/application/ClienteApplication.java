package com.locadora.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.locadora.model.Cliente;
import com.locadora.model.Dependente;
import com.locadora.model.Socio;
import com.locadora.repository.DependenteRepository;

@Service
public class ClienteApplication extends GenericApplication<Cliente>{

    @Autowired
    DependenteRepository dependenteRepository;
    
    public ClienteApplication(JpaRepository<Cliente, Long> repository){
        super(repository, Cliente.class);
    }

    public Cliente trocarEstadoDoCliente(Cliente cliente){
        if (cliente.isEstahAtivo()) {
            if (cliente instanceof Socio) 
            {
                List<Dependente> dependentes = dependenteRepository.findBySocioId(cliente.getId());
                for (Dependente dep: dependentes){
                    dep.setEstahAtivo(false);
                }
                cliente.setEstahAtivo(false);
            }
            else
            {
                cliente.setEstahAtivo(false);
            }
        } else {
            if (cliente instanceof Dependente){
                long socioId = ((Dependente)cliente).getSocio().getId();
                List<Dependente> dependentes = dependenteRepository.findBySocioIdAndEstahAtivoIsTrue(socioId);
                if (dependentes.size() >= 3) {
                    throw new RuntimeException("Limite de 3 dependentes ativos por sócio.");
                } else {
                    cliente.setEstahAtivo(true);
                }
            } 
            else
            {
                cliente.setEstahAtivo(true);
            }
        }

        objRepository.save(cliente);
        return cliente;
    }

}
