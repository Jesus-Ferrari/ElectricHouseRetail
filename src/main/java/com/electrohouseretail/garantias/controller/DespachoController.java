package com.electrohouseretail.garantias.controller;

import com.electrohouseretail.garantias.model.Despacho;
import com.electrohouseretail.garantias.service.DespachoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class DespachoController {

    @Autowired
    private DespachoService despachoService;

    @GetMapping("/api/v1/despacho")
    public ResponseEntity<?> getDespachos() {

        List<Despacho> despachos = despachoService.findAll();
        return ResponseEntity.status(200).body(despachos);

    }

    @GetMapping("/api/v1/despacho/{id}")
    public ResponseEntity<?> getDespacho(@PathVariable Integer id) {

        Despacho despacho = despachoService.findById(id);

        if(despacho == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(despacho);

    }

    @DeleteMapping("/api/v1/despacho/{id}")
    public ResponseEntity<?> deleteDespacho(@PathVariable Integer id) {
        Despacho despacho = despachoService.findById(id);
        if(despacho == null) {
            return ResponseEntity.status(404).build();
        }
        despachoService.delete(id);
        return ResponseEntity.status(200).body("Despacho eliminado");
    }

    @PostMapping("/api/v1/despacho")
    public ResponseEntity<?> crearDespacho(@RequestBody Despacho despacho) {
        Despacho nuevoDespacho = despachoService.save(despacho);

        return ResponseEntity.status(201).body(nuevoDespacho);
    }


}
