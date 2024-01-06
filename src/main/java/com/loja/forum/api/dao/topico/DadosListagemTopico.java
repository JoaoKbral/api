package com.loja.forum.api.dao.topico;

import java.time.LocalDate;

import com.loja.forum.api.models.Curso;
import com.loja.forum.api.models.StatusTopico;
import com.loja.forum.api.models.Topico;
import com.loja.forum.api.models.Usuario;

public record DadosListagemTopico(String titulo,
        String mensagem,
        LocalDate dataCriacao,
        StatusTopico status,
        Usuario usuario,
        Curso curso) {

    public DadosListagemTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(),
                topico.getUsuarioId(), topico.getCurso());
    }
}
