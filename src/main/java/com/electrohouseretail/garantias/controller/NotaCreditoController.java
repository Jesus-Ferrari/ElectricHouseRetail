package com.electrohouseretail.garantias.controller;

import com.electrohouseretail.garantias.model.NotaCredito;
import com.electrohouseretail.garantias.service.NotaCreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class NotaCreditoController {

    @Autowired
    private NotaCreditoService notaCreditoService;

    @GetMapping("/api/v1/notaCredito")
    public ResponseEntity<?> getNotaCreditos() {

        List<NotaCredito> notaCreditos = notaCreditoService.findAll();
        return ResponseEntity.status(200).body(notaCreditos);

    }

    @GetMapping("/api/v1/notaCredito/{id}")
    public ResponseEntity<?> getNotaCreditos(@PathVariable Integer id) {

        NotaCredito notaCredito = notaCreditoService.findById(id);

        if(notaCredito == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(notaCredito);

    }

    @PostMapping("/api/v1/notaCredito")
    public ResponseEntity<?> crearNotaCreditos(@RequestBody NotaCredito notaCredito) {
        NotaCredito nuevoNotaCredito = notaCreditoService.save(notaCredito);

        return ResponseEntity.status(201).body(nuevoNotaCredito);
    }

    @PutMapping("/api/v1/notaCredito/{id}")
    public ResponseEntity<?> updateNotaCredito(@PathVariable Integer id, @RequestBody NotaCredito notaActualizada) {
        NotaCredito actualizada = notaCreditoService.update(id, notaActualizada);

        if (actualizada == null) {
            return ResponseEntity.status(404).body("Nota de crédito no encontrada");
        }

        return ResponseEntity.status(200).body(actualizada);
    }


}
