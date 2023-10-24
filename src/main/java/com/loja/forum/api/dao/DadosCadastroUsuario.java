package com.loja.forum.api.dao;

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
    
}
