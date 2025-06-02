package com.electrohouseretail.garantias.controller;

import com.electrohouseretail.garantias.model.OrdenRetiro;
import com.electrohouseretail.garantias.service.OrdenRetiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class OrdenRetiroController {

    @Autowired
    private OrdenRetiroService ordenRetiroService;

    @GetMapping("/api/v1/ordenRetiro")
    public ResponseEntity<?> getOrdenRetiros() {

        List<OrdenRetiro> ordenRetiros = ordenRetiroService.findAll();
        return ResponseEntity.status(200).body(ordenRetiros);

    }

    @GetMapping("/api/v1/ordenRetiro/{id}")
    public ResponseEntity<?> getOrdenRetiro(@PathVariable Integer id) {

        OrdenRetiro ordenRetiro = ordenRetiroService.findById(id);

        if(ordenRetiro == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(ordenRetiro);

    }

    @DeleteMapping("/api/v1/ordenRetiro/{id}")
    public ResponseEntity<?> deleteOrdenRetiro(@PathVariable Integer id) {
        OrdenRetiro ordenRetiro = ordenRetiroService.findById(id);
        if(ordenRetiro == null) {
            return ResponseEntity.status(404).build();
        }
        ordenRetiroService.delete(id);
        return ResponseEntity.status(200).body("Orden de Retiro eliminado");
    }

    @PostMapping("/api/v1/ordenRetiro")
    public ResponseEntity<?> crearOrdenRetiro(@RequestBody OrdenRetiro ordenRetiro) {
        OrdenRetiro nuevoOrdenRetiro = ordenRetiroService.save(ordenRetiro);

        return ResponseEntity.status(201).body(nuevoOrdenRetiro);
    }

    @PutMapping("/api/v1/ordenRetiro/{id}")
    public ResponseEntity<?> updateOrdenRetiro(@PathVariable Integer id, @RequestBody OrdenRetiro ordenActualizada) {
        OrdenRetiro actualizada = ordenRetiroService.update(id, ordenActualizada);

        if (actualizada == null) {
            return ResponseEntity.status(404).body("Orden de retiro no encontrada");
        }

        return ResponseEntity.status(200).body(actualizada);
    }


}

