package com.electrohouseretail.garantias.controller;

import com.electrohouseretail.garantias.model.Usuario;
import com.electrohouseretail.garantias.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/api/v1/usuario")
    public ResponseEntity<?> getUsuarios() {

        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.status(200).body(usuarios);

    }

    @GetMapping("/api/v1/usuario/{id}")
    public ResponseEntity<?> getUsuario(@PathVariable Integer id) {

        Usuario usuario = usuarioService.findById(id);

        if(usuario == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(usuario);

    }

    @DeleteMapping("/api/v1/usuario/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable Integer id) {
        Usuario usuario = usuarioService.findById(id);
        if(usuario == null) {
            return ResponseEntity.status(404).build();
        }
        usuarioService.delete(id);
        return ResponseEntity.status(200).body("Usuario eliminado");
    }

    @PutMapping("/api/v1/usuario/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuarioActualizado) {
        Usuario actualizado = usuarioService.update(id, usuarioActualizado);

        if (actualizado == null) {
            return ResponseEntity.status(404).body("Usuario no encontrado");
        }

        return ResponseEntity.status(200).body(actualizado);
    }


    @PostMapping("/api/v1/usuario")
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.save(usuario);

        return ResponseEntity.status(201).body(nuevoUsuario);
    }

    @PostMapping("/api/v1/iniciosesion")
    public ResponseEntity<?> iniciarSesion(@RequestBody Usuario usuario) {
        Usuario usuarioEncontrado = usuarioService.login(usuario.getUsername(), usuario.getPassword());

        if (usuarioEncontrado == null) {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }

        return ResponseEntity.status(200).body("Sesion iniciada correctamente");
    }


}
