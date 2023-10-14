package com.loja.forum.api.repositories.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loja.forum.api.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
