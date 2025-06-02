package com.electrohouseretail.garantias.controller;

import com.electrohouseretail.garantias.model.Producto;
import com.electrohouseretail.garantias.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/api/v1/producto")
    public ResponseEntity<?> getProductos() {

        List<Producto> productos = productoService.findAll();
        return ResponseEntity.status(200).body(productos);

    }

    @GetMapping("/api/v1/producto/{id}")
    public ResponseEntity<?> getProducto(@PathVariable Integer id) {

        Producto producto = productoService.findById(id);

        if(producto == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(producto);

    }

    @DeleteMapping("/api/v1/producto/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable Integer id) {
        Producto producto = productoService.findById(id);
        if(producto == null) {
            return ResponseEntity.status(404).build();
        }
        productoService.delete(id);
        return ResponseEntity.status(200).body("Producto eliminado");
    }

    @PostMapping("/api/v1/producto")
    public ResponseEntity<?> crearProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoService.save(producto);

        return ResponseEntity.status(201).body(nuevoProducto);
    }

    @GetMapping("/api/v1/producto/{id}/stock")
    public ResponseEntity<?> getProductoStock(@PathVariable Integer id) {

        Producto producto = productoService.findById(id);

        if(producto == null) {
            return ResponseEntity.status(404).build();
        } else {
            if (producto.getStock() == 0) {
                return ResponseEntity.status(200).body("No hay stock de producto");
            } else {
                return ResponseEntity.status(200).body(producto.getStock());
            }

        }


    }

    @PutMapping("/api/v1/producto/{id}")
    public ResponseEntity<?> updateProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        Producto actualizado = productoService.update(id, producto);
        if (actualizado == null) {
            return ResponseEntity.status(404).body("Producto no encontrado");
        }
        return ResponseEntity.ok(actualizado);
    }

}
