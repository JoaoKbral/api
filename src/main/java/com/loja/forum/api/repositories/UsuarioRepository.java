package com.loja.forum.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loja.forum.api.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
