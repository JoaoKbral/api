package com.loja.forum.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.loja.forum.api.dao.usuario.DadosAtualizarUsuario;
import com.loja.forum.api.dao.usuario.DadosCadastroUsuario;
import com.loja.forum.api.models.Usuario;
import com.loja.forum.api.services.UsuarioService;

import jakarta.transaction.Transactional;
import lombok.var;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService; 

    @GetMapping("/listar")
    public List<Usuario> listagem() {
        return usuarioService.getListagem();
    }
    

    // TODO n esquecer de colocar as validações
    @PostMapping("cadastro")
    @Transactional
    public ResponseEntity<DadosCadastroUsuario> cadastrar(@RequestBody @Validated DadosCadastroUsuario dados,
            UriComponentsBuilder uriBuilder) {

        var usuario = new Usuario(dados);
        
        usuarioService.cadastrar(usuario);
        var usuarioCadatrado = usuarioService.cadastrar(usuario);

        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(usuarioCadatrado);
    }

    @PutMapping
    @Transactional
    public void atualizarCadastro(DadosAtualizarUsuario dados) {
        usuarioService.atualizar(dados);
    }

    @DeleteMapping
    @Transactional
    public void deletarCadastro() {

    }

}
