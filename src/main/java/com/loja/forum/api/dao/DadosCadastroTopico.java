package com.loja.forum.api.dao;

import java.time.LocalDate;

import com.loja.forum.api.models.Curso;
import com.loja.forum.api.models.StatusTopico;
import com.loja.forum.api.models.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(
    @NotBlank
    String titulo,
    @NotBlank
    String mensagem,
    LocalDate dataCriacao,
    @NotBlank
    StatusTopico status,
    @NotNull
    Usuario usuarioId,
    @NotNull
    Curso cursoId
    )
{
}
