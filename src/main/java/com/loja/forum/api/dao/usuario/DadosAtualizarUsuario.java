package com.loja.forum.api.dao.usuario;

public record DadosAtualizarUsuario(
    Long id,
    String nome,
    String email,
    String senha
) {
}