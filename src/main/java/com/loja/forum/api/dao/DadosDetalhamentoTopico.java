package com.loja.forum.api.dao;

import java.time.LocalDate;

import com.loja.forum.api.models.Curso;
import com.loja.forum.api.models.StatusTopico;
import com.loja.forum.api.models.Topico;
import com.loja.forum.api.models.Usuario;

public record DadosDetalhamentoTopico(
    String titulo,
    String mensagem,
    LocalDate dataCriacao,
    StatusTopico status,
    Usuario usuarioId,
    Curso cursoId
    )
{

    public DadosDetalhamentoTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(), topico.getUsuarioId(), topico.getCurso());
    }
}
