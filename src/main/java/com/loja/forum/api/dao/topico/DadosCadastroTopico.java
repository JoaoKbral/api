package com.loja.forum.api.dao.topico;

import com.loja.forum.api.models.Curso;
import com.loja.forum.api.models.Topico;
import com.loja.forum.api.models.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(
    @NotBlank
    String titulo,
    @NotBlank
    String mensagem,
    @NotNull
    Usuario usuarioId,
    @NotNull
    Curso cursoId
    )
{

    public DadosCadastroTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensagem(), topico.getUsuarioId(), topico.getCurso());
    }
}
