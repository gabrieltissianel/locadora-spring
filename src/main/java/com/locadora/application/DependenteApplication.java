package com.locadora.application;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.locadora.model.Dependente;
import com.locadora.repository.DependenteRepository;

@Service
public class DependenteApplication extends GenericApplication<Dependente> {

    public DependenteApplication(DependenteRepository repository){
        super(repository, Dependente.class);
    }

    @Override
    public ResponseEntity<Dependente> add(Dependente obj) {
        List<Dependente> dependentes_socio = ((DependenteRepository) objRepository).findBySocioIdAndEstahAtivoIsTrue(obj.getSocio().getId());

        if(dependentes_socio != null && dependentes_socio.size() == 3){
            throw new RuntimeException("Limite de 3 dependentes ativos por Sócio");
        }

        return super.add(obj);
    }

    public ResponseEntity<List<Dependente>> listSocioDependentes(long id_socio){ 
        return ResponseEntity.ok().body(((DependenteRepository) objRepository).findBySocioId(id_socio));
    }

    public ResponseEntity<Dependente> trocarEstadoDoDependente(Dependente cliente){
        if (cliente.isEstahAtivo()) {
            cliente.setEstahAtivo(false);
        } else {
            long socioId = (cliente).getSocio().getId();
            List<Dependente> dependentes = ((DependenteRepository)objRepository).findBySocioIdAndEstahAtivoIsTrue(socioId);
            if (dependentes.size() >= 3) {
                throw new RuntimeException("Limite de 3 dependentes ativos por sócio.");
            } else {
                cliente.setEstahAtivo(true);
            }       
        }

        objRepository.save(cliente);
        return ResponseEntity.ok().body(cliente);
    }
}
