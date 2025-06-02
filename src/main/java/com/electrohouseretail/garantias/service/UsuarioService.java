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

    public List<Usuario> findByRolId(Integer id) {
        return usuarioRepository.findByRolId(id);
    }

    public Usuario login(String username, String password) {
        return usuarioRepository.findByUsernameAndPassword(username, password).orElse(null);
    }

    public Usuario update(Integer id, Usuario usuarioActualizado) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        if (usuario == null) {
            return null;
        }

        usuario.setUsername(usuarioActualizado.getUsername());
        usuario.setPassword(usuarioActualizado.getPassword());
        usuario.setNombre(usuarioActualizado.getNombre());
        usuario.setApellidoPaterno(usuarioActualizado.getApellidoPaterno());
        usuario.setApellidoMaterno(usuarioActualizado.getApellidoMaterno());
        usuario.setCorreo(usuarioActualizado.getCorreo());
        //usuario.setRut(usuarioActualizado.getRut());
        usuario.setTelefono(usuarioActualizado.getTelefono());
        usuario.setDireccion(usuarioActualizado.getDireccion());
        usuario.setRol(usuarioActualizado.getRol());

        return usuarioRepository.save(usuario);
    }


}
