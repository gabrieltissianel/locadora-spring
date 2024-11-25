package com.locadora.application;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.locadora.exception.NotFoundException;
import com.locadora.model.Identity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GenericApplication<E extends Identity> {

    protected final JpaRepository<E, Long> objRepository;

    private final Class classe;

    /**
     * Lista todos os registros.
     * @return ResponseEntity contendo uma lista de objetos.
     */
    @Operation(summary = "Listar todos os registros", description = "Retorna uma lista de todos os objetos do repositório.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso", 
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = List.class)))
    })
    public ResponseEntity<List<E>> list() {
        return ResponseEntity.ok().body(objRepository.findAll());
    }

    /**
     * Adiciona um novo registro.
     * @param obj Objeto a ser adicionado.
     * @return ResponseEntity contendo o objeto criado.
     */
    @Operation(summary = "Adicionar um novo registro", description = "Adiciona um novo objeto ao repositório.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Objeto criado com sucesso", 
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Identity.class)))
    })
    public ResponseEntity<E> add(E obj) {
        objRepository.save(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    /**
     * Remove um registro pelo ID.
     * @param id ID do registro a ser removido.
     * @return Mensagem de sucesso.
     */
    @Operation(summary = "Remover um registro", description = "Remove um objeto do repositório pelo ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Objeto removido com sucesso", 
            content = @Content(mediaType = "text/plain")),
        @ApiResponse(responseCode = "404", description = "Objeto não encontrado",
            content = @Content(mediaType = "application/json"))
    })
    public ResponseEntity<String> remove(long id) {
        objRepository.findById(id).orElseThrow(() -> new NotFoundException(classe.getSimpleName()));
        objRepository.deleteById(id);        
        return ResponseEntity.ok().body(classe.getSimpleName() + " excluído com sucesso"); 
    }

    /**
     * Atualiza um registro existente.
     * @param obj Objeto atualizado.
     * @return ResponseEntity contendo o objeto atualizado.
     */
    @Operation(summary = "Atualizar um registro", description = "Atualiza um objeto existente no repositório.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Objeto atualizado com sucesso", 
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Identity.class))),
        @ApiResponse(responseCode = "404", description = "Objeto não encontrado",
            content = @Content(mediaType = "application/json"))
    })
    public ResponseEntity<E> update(E obj) {
        objRepository.findById(obj.getId()).orElseThrow(() -> new NotFoundException(classe.getSimpleName()));
        objRepository.save(obj);
        return ResponseEntity.ok().body(obj);
    }
}
