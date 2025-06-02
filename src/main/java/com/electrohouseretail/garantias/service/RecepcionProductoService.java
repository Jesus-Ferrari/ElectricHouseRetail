package com.electrohouseretail.garantias.service;

import com.electrohouseretail.garantias.model.RecepcionProducto;
import com.electrohouseretail.garantias.repository.RecepcionProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class RecepcionProductoService {

    @Autowired
    private RecepcionProductoRepository recepcionProductoRepository;
    public List<RecepcionProducto> findAll() {
        return recepcionProductoRepository.findAll();
    }

    public RecepcionProducto findById(Integer id) {
        return recepcionProductoRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        recepcionProductoRepository.deleteById(id);
    }

    public RecepcionProducto save(RecepcionProducto recepcionProducto) {
        return recepcionProductoRepository.save(recepcionProducto);
    }

    public RecepcionProducto update(Integer id, RecepcionProducto recepcionActualizada) {
        RecepcionProducto existente = recepcionProductoRepository.findById(id).orElse(null);
        if (existente == null) {
            return null;
        }

        existente.setFechaRecepcion(recepcionActualizada.getFechaRecepcion());
        existente.setEstadoRecepcion(recepcionActualizada.getEstadoRecepcion());
        existente.setResponsable(recepcionActualizada.getResponsable());
        //existente.setSolicitud(recepcionActualizada.getSolicitud());

        return recepcionProductoRepository.save(existente);
    }


}
