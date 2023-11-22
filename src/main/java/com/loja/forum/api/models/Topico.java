package com.loja.forum.api.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import com.loja.forum.api.dao.DadosAtualizarTopico;
import com.loja.forum.api.dao.DadosCadastroTopico;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Topico")
@Table(name = "topicos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Topico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDate dataCriacao = LocalDate.now();

	@Enumerated(EnumType.STRING)
	private StatusTopico status = StatusTopico.NAO_RESPONDIDO;

	// TODO arrumar cardinalizacao
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuarioId;
	// TODO arrumar cardinalizacao

	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Resposta> repostas = new ArrayList<Resposta>();

	public Topico(DadosCadastroTopico dados) {
		this(null, dados.titulo(),dados.mensagem(),dados.dataCriacao(),dados.status(),dados.usuarioId(),dados.cursoId());
	}

    public void atualizar(@Valid DadosAtualizarTopico dados) {
		if(!dados.titulo().isBlank()){
			this.titulo = dados.titulo();
		}
		if(!dados.mensagem().isBlank()){
			this.mensagem = dados.mensagem();
		}
		if(dados.status() != null){
			this.status = dados.status();
		}
		if(dados.curso() != null){
			this.curso = dados.curso();
		}
    }

	public Topico(Long id, String titulo, String mensagem, LocalDate dataCriacao, StatusTopico status,
			Usuario usuarioId, Curso cursoId) {
	}

}
