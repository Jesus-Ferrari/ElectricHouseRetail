package com.electrohouseretail.garantias.controller;

import com.electrohouseretail.garantias.model.Boleta;
import com.electrohouseretail.garantias.service.BoletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class BoletaController {

    @Autowired
    private BoletaService boletaService;

    @GetMapping("/api/v1/boleta")
    public ResponseEntity<?> getBoletas() {

        List<Boleta> boletas = boletaService.findAll();
        return ResponseEntity.status(200).body(boletas);

    }

    @GetMapping("/api/v1/boleta/{id}")
    public ResponseEntity<?> getBoleta(@PathVariable Integer id) {

        Boleta boleta = boletaService.findById(id);

        if(boleta == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(boleta);

    }

    @DeleteMapping("/api/v1/boleta/{id}")
    public ResponseEntity<?> deleteBoleta(@PathVariable Integer id) {
        Boleta boleta = boletaService.findById(id);
        if(boleta == null) {
            return ResponseEntity.status(404).build();
        }
        boletaService.delete(id);
        return ResponseEntity.status(200).body("Boleta eliminado");
    }

    @PostMapping("/api/v1/boleta")
    public ResponseEntity<?> crearBoleta(@RequestBody Boleta boleta) {
        Boleta nuevaBoleta = boletaService.save(boleta);

        return ResponseEntity.status(201).body(nuevaBoleta);
    }

}
