package com.loja.forum.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loja.forum.api.models.Topico;

public interface TopicoRepository extends JpaRepository <Topico, Long>{
    
}
