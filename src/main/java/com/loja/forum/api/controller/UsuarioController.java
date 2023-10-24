package com.loja.forum.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loja.forum.api.dao.DadosCadastroUsuario;
import com.loja.forum.api.models.Usuario;
import com.loja.forum.api.repositories.UsuarioRepository;

@RequestMapping
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //TODO n esquecer de colocar as validações
    @PostMapping
    public void cadastrar(@RequestBody @Validated DadosCadastroUsuario dados){
        usuarioRepository.save(new Usuario(dados));
    }

    public void atualizarCadastro(Object recebe){
        
    }
    public void deletarCadastro(){}
    // public void (){}

}
