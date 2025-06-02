package com.electrohouseretail.garantias.controller;

import com.electrohouseretail.garantias.model.Rol;
import com.electrohouseretail.garantias.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("/api/v1/rol")
    public ResponseEntity<?> getAllRol() {
        List<Rol> rols = rolService.findAll();
        return ResponseEntity.status(200).body(rols);
    }

    @GetMapping("/api/v1/rol/{id}")
    public ResponseEntity<?> getRolById(@PathVariable Integer id) {

        Rol rol = rolService.findById(id);

        if(rol == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(rol);

    }

    @DeleteMapping("/api/v1/rol/{id}")
    public ResponseEntity<?> deleteRol(@PathVariable Integer id) {
        Rol rol = rolService.findById(id);
        if (rol == null) {
            return ResponseEntity.status(404).body("Rol no encontrado");
        }

        try {
            rolService.delete(id);
            return ResponseEntity.status(200).body("Rol eliminado");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(409).body("No se puede eliminar el rol porque está asociado a uno o más usuarios");
        }
    }


    @PostMapping("/api/v1/rol")
    public ResponseEntity<?> crearRol(@RequestBody Rol rol) {
        Rol nuevoRol = rolService.save(rol);

        return ResponseEntity.status(201).body(nuevoRol);
    }

    @PutMapping("/api/v1/rol/{id}")
    public ResponseEntity<?> updateRol(@PathVariable Integer id, @RequestBody Rol rol) {
        Rol actualizado = rolService.update(id, rol);
        if (actualizado == null) {
            return ResponseEntity.status(404).body("Rol no encontrado");
        }
        return ResponseEntity.ok(actualizado);
    }

}
