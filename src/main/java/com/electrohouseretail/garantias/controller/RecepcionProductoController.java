package com.electrohouseretail.garantias.controller;

import com.electrohouseretail.garantias.model.RecepcionProducto;
import com.electrohouseretail.garantias.service.RecepcionProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class RecepcionProductoController {

    @Autowired
    private RecepcionProductoService recepcionProductoService;

    @GetMapping("/api/v1/recepcionProducto")
    public ResponseEntity<?> getRecepcionProductos() {

        List<RecepcionProducto> recepcionProductos = recepcionProductoService.findAll();
        return ResponseEntity.status(200).body(recepcionProductos);

    }

    @GetMapping("/api/v1/recepcionProducto/{id}")
    public ResponseEntity<?> getRecepcionProductos(@PathVariable Integer id) {

        RecepcionProducto recepcionProducto = recepcionProductoService.findById(id);

        if(recepcionProducto == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(recepcionProducto);

    }

    @DeleteMapping("/api/v1/recepcionProducto/{id}")
    public ResponseEntity<?> deleteRecepcionProductos(@PathVariable Integer id) {
        RecepcionProducto recepcionProducto = recepcionProductoService.findById(id);
        if(recepcionProducto == null) {
            return ResponseEntity.status(404).build();
        }
        recepcionProductoService.delete(id);
        return ResponseEntity.status(200).body("Recepcion de Producto eliminada");
    }

    @PostMapping("/api/v1/recepcionProducto")
    public ResponseEntity<?> crearRecepcionProducto(@RequestBody RecepcionProducto recepcionProducto) {
        RecepcionProducto nuevoRecepcionProducto = recepcionProductoService.save(recepcionProducto);

        return ResponseEntity.status(201).body(nuevoRecepcionProducto);
    }



}
