package com.locadora.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.locadora.application.GenericApplication;
import com.locadora.model.Identity;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

/**
 * Controlador genérico para operações CRUD.
 * Esta classe expõe os endpoints para manipular as entidades do sistema.
 * @param <E> Entidade que estende Identity.
 */
@OpenAPIDefinition(
    info = @Info(
        title = "Locadora",
        version = "1.0.0",
        description = "Trabalho web2",
        contact = @Contact(name = "Murilo", email = "teste@gamil.com")
    )
)
@Tag(name = "Entidades", description = "Endpoints genéricos para gerenciar entidades no sistema")
@AllArgsConstructor
public class GenericController<E extends Identity> {

    protected final GenericApplication<E> genericApplication;

    /**
     * Lista todas as entidades do tipo E.
     * @return Lista de entidades E.
     */
    @Operation(summary = "Lista todas as entidades", description = "Recupera todas as entidades do tipo E.")
    @GetMapping("/list")
    public ResponseEntity<List<E>> list() {
        return genericApplication.list();
    }

    /**
     * Adiciona uma nova entidade do tipo E.
     * @param obj A entidade a ser adicionada.
     * @return A entidade adicionada.
     */
    @Operation(summary = "Adiciona uma nova entidade", description = "Adiciona uma nova entidade do tipo E no sistema.")
    @PostMapping("/add")
    public ResponseEntity<E> add(@Valid @RequestBody E obj) {
        return genericApplication.add(obj);
    }

    /**
     * Remove uma entidade com o ID especificado.
     * @param id O ID da entidade a ser removida.
     * @return Mensagem de sucesso.
     */
    @Operation(summary = "Remove uma entidade", description = "Remove uma entidade do tipo E pelo ID fornecido.")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> remove(@Parameter(description = "ID da entidade a ser removida") @PathVariable long id) {
        return genericApplication.remove(id);
    }

    /**
     * Edita uma entidade existente.
     * @param obj A entidade com os dados atualizados.
     * @return A entidade atualizada.
     */
    @Operation(summary = "Edita uma entidade", description = "Edita uma entidade do tipo E existente no sistema.")
    @PostMapping("/edit")
    public ResponseEntity<E> edit(@Valid @RequestBody E obj) {
        return genericApplication.update(obj);
    }
}
