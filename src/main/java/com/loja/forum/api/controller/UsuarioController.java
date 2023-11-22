package com.loja.forum.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.loja.forum.api.dao.DadosCadastroUsuario;
import com.loja.forum.api.models.Usuario;
import com.loja.forum.api.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.var;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // TODO n esquecer de colocar as validações
    @PostMapping
    @Transactional
    public ResponseEntity<DadosCadastroUsuario> cadastrar(@RequestBody @Validated DadosCadastroUsuario dados,
            UriComponentsBuilder uriBuilder) {

        var usuario = new Usuario(dados);
        usuarioRepository.save(usuario);

        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosCadastroUsuario(usuario));
    }

    @PutMapping
    @Transactional
    public void atualizarCadastro(Object dados) {

    }

    @DeleteMapping
    @Transactional
    public void deletarCadastro() {
    }

}
