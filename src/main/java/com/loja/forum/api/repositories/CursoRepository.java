package com.loja.forum.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loja.forum.api.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{
    
}
