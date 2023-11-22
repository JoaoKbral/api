package com.loja.forum.api.dao;

import com.loja.forum.api.models.Usuario;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@Valid
public record DadosCadastroUsuario(
    @NotBlank
    String nome,
    @NotBlank
	String email,
    @NotBlank
	String senha
) {

    public DadosCadastroUsuario(Usuario usuario) {
        this(usuario.getNome(), usuario.getEmail(), usuario.getSenha());
    }
    
}
