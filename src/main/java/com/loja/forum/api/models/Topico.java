package com.loja.forum.api.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.loja.forum.api.dao.topico.DadosAtualizarTopico;
import com.loja.forum.api.dao.topico.DadosCadastroTopico;

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
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Topico")
@Table(name = "topicos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
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
		this( dados.titulo(),dados.mensagem(),dados.usuarioId(),dados.cursoId());
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

	// TODO n sei o que é
	public Topico( String titulo, String mensagem, Usuario usuarioId, Curso cursoId) {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topico other = (Topico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

}
