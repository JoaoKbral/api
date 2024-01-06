package com.loja.forum.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.loja.forum.api.dao.usuario.DadosAtualizarUsuario;
import com.loja.forum.api.dao.usuario.DadosCadastroUsuario;
import com.loja.forum.api.models.Usuario;
import com.loja.forum.api.repositories.UsuarioRepository;
import com.loja.forum.api.security.SecurityConfigurations;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private SecurityConfigurations config;

    public List<Usuario> getListagem(){
        return usuarioRepository.findAll();
    }

    @Transactional
    public DadosCadastroUsuario cadastrar(Usuario usuario){
        String senha = config.passwordEncoder().encode(usuario.getSenha());
        var user = new Usuario(usuario.getNome(), usuario.getEmail(), senha);

        usuarioRepository.save(user);

        return new DadosCadastroUsuario(user);
    }

    @Transactional
    public void deletar(Usuario usuario){
        usuarioRepository.delete(usuario);
    }

    @Transactional
    public void atualizar(DadosAtualizarUsuario dados){
        Usuario usuario = usuarioRepository.getReferenceById(dados.id());
        
        usuario.atualizar(dados);
        
    }
}
