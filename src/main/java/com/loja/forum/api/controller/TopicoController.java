package com.loja.forum.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.loja.forum.api.dao.DadosAtualizarTopico;
import com.loja.forum.api.dao.DadosCadastroTopico;
import com.loja.forum.api.dao.DadosDetalhamentoTopico;
import com.loja.forum.api.dao.DadosListagemTopico;
import com.loja.forum.api.models.Topico;
import com.loja.forum.api.repositories.TopicoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.var;

@RestController
@RequestMapping("topicos")
public class TopicoController {
    
    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity <DadosCadastroTopico> criar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder){
        var topico = new Topico(dados);
        topicoRepository.save(new Topico(dados));

        var uri =  uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosCadastroTopico (topico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoTopico> atualizar(@RequestBody @Valid DadosAtualizarTopico dados){
        var topico =  topicoRepository.getReferenceById(dados.id());
        topico.atualizar(dados);

        return ResponseEntity.ok(new DadosDetalhamentoTopico (topico));
    }

    @DeleteMapping
    public void deletar(){
        // TODO implementar delete
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoTopico> detalhar(@PathVariable Long id){
        var topico = topicoRepository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    public ResponseEntity<Page<DadosListagemTopico>> listar(@PageableDefault (size = 10) Pageable pageable){
        var page = topicoRepository.findAll(pageable).map(DadosListagemTopico::new);
        return ResponseEntity.ok(page);
    }

}
