package com.loja.forum.api.dao.topico;

import com.loja.forum.api.models.Curso;
import com.loja.forum.api.models.StatusTopico;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTopico(
    @NotNull
    Long id,
    String titulo,
    String mensagem,
    StatusTopico status,
    Curso curso
    )
{
}
