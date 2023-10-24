package com.loja.forum.api.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Resposta")
@Table(name = "repostas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String mensagem;
    
    @ManyToOne(fetch = FetchType.LAZY)
	private Topico topico;
    @Column(name = "data_de_criacao")
	private LocalDate dataCriacao = LocalDate.now();
    @ManyToOne
	private Usuario usuario;
	private Boolean solucao = false;

}
