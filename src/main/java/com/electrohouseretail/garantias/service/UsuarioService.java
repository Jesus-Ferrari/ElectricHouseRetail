package com.electrohouseretail.garantias.service;

import com.electrohouseretail.garantias.model.Usuario;
import com.electrohouseretail.garantias.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario login(String username, String password) {
        return usuarioRepository.findByUsernameAndPassword(username, password).orElse(null);
    }

}
