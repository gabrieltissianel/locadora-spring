package com.locadora.application;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.locadora.exception.ItemJaAlocadoException;
import com.locadora.exception.NotFoundException;
import com.locadora.model.Locacao;
import com.locadora.repository.LocadoraRepository;

@Service
public class LocacaoApplication extends GenericApplication<Locacao>{

    public LocacaoApplication(JpaRepository<Locacao, Long> repository){
        super(repository, Locacao.class);
    }

    @Override
    public ResponseEntity<String> remove(long id) {
        Optional<Locacao> locacao = objRepository.findById(id);

        if (locacao.isPresent() && locacao.get().getDtDevolucaoEfetiva() != null) {
            throw new RuntimeException("Locação paga não pode ser deletada.");
        }

        return super.remove(id);
    }

    @Override
    public ResponseEntity<Locacao> update(Locacao obj) {
        validarLocacao(obj);
        return super.update(obj);
    }

    @Override
    public ResponseEntity<Locacao> add(Locacao obj) {
        
        if(!obj.getCliente().isEstahAtivo()){
            throw new RuntimeException("Cliente está inativo.");
        }

        List<Locacao> locacoes_cliente = ((LocadoraRepository) objRepository).findByClienteIdAndDtDevolucaoEfetivaIsNull(obj.getCliente().getId());

        for(Locacao locacao: locacoes_cliente){
            if(locacao.getDtDevolucaoPrevista().isBefore(LocalDate.now())){
                throw new RuntimeException("Cliente em débito.");
            }
        }

        validarLocacao(obj);
        return super.add(obj);
    }

    public ResponseEntity<Locacao> buscarLocacao(int itemSerie){
        Optional<Locacao> locacao =  ((LocadoraRepository) objRepository).findByItemNumSerieAndDtDevolucaoEfetivaIsNull(itemSerie);

        if (!locacao.isPresent()) {
            throw new RuntimeException("Item não está locado.");
        }

        return ResponseEntity.ok().body( locacao.get() );
    }

    public ResponseEntity<Locacao> devolverLocacao(Locacao obj){
        objRepository.findById(obj.getId()).orElseThrow(()-> new NotFoundException("Locação"));

        validarLocacao(obj);

        obj.setDtDevolucaoEfetiva(LocalDate.now());

        if (!obj.getDtDevolucaoPrevista().isBefore(obj.getDtDevolucaoEfetiva())) {
            obj.setMultaCobrada(0);
        }

        objRepository.save(obj);

        return ResponseEntity.ok().body(obj);
    }

    private void validarLocacao(Locacao obj){

        // Verifica se o item já está alocado
        List<Locacao> locacoes = ((LocadoraRepository) objRepository).findByDtDevolucaoEfetivaIsNull();

        for(Locacao locacao : locacoes){
            if (locacao.getId() != obj.getId() && locacao.getItem().getId() == obj.getItem().getId()) {
                throw new ItemJaAlocadoException(locacao);
            }
        }
        
        //Se a data é null será setado a data de hoje
        if (obj.getDtLocacao() == null) 
        {
            obj.setDtLocacao(LocalDate.now());
        }

        //Se a data de devolução é null será setado a data padrão do Item
        if (obj.getDtDevolucaoPrevista() == null)
        {
            obj.setDtDevolucaoPrevista( obj.getDtLocacao().plusDays( obj.getItem().getTitulo().getClasse().getPrazoDevolucao() ));
        }
        else if (obj.getDtDevolucaoPrevista().isBefore( obj.getDtLocacao() )) 
        {
            throw new RuntimeException("Data de devolução inválida.");
        }

        //Verifica a Data de Devolucão
        if (obj.getDtDevolucaoEfetiva() != null  
         && obj.getDtDevolucaoEfetiva().isBefore(obj.getDtLocacao())) 
        {
            throw new RuntimeException("Data de devolução inválida.");
        }
 
        //Verifica o valor cobrado
        if (obj.getValorCobrado() == 0) {
            obj.setValorCobrado(obj.getItem().getTitulo().getClasse().getValue());
        }

        if (obj.getDtDevolucaoEfetiva() != null && !obj.getDtDevolucaoPrevista().isBefore(obj.getDtDevolucaoEfetiva())) {
            obj.setMultaCobrada(0);
        }
    } 
}   
