package com.loja.forum.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loja.forum.api.models.Resposta;

public interface RespostaRepository extends JpaRepository<Resposta, Long>{
    
}
