package com.electrohouseretail.garantias.service;

import com.electrohouseretail.garantias.model.Producto;
import com.electrohouseretail.garantias.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Producto findById(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        productoRepository.deleteById(id);
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

}
