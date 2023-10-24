package com.loja.forum.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.loja.forum.api.dao.DadosAtualizarTopico;
import com.loja.forum.api.dao.DadosCadastroTopico;
import com.loja.forum.api.models.Topico;
import com.loja.forum.api.repositories.TopicoRepository;

import jakarta.validation.Valid;

public class TopicoController {
    
    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public void criar(@RequestBody @Valid DadosCadastroTopico dados){
        topicoRepository.save(new Topico(dados));
    }

    @PutMapping
    public void atualizar(@RequestBody @Valid DadosAtualizarTopico dados){
        var topico =  topicoRepository.getReferenceById(dados.id());
        topico.atualizar(dados);
    }

    @DeleteMapping
    public void deletar(){

    }

    @GetMapping
    public void detalhar(){

    }

}
