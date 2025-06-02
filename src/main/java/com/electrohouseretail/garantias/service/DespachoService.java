package com.electrohouseretail.garantias.service;

import com.electrohouseretail.garantias.model.Despacho;
import com.electrohouseretail.garantias.repository.DespachoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class DespachoService {

    @Autowired
    private DespachoRepository despachoRepository;
    public List<Despacho> findAll() {
        return despachoRepository.findAll();
    }

    public Despacho findById(Integer id) {
        return despachoRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        despachoRepository.deleteById(id);
    }

    public Despacho save(Despacho despacho) {
        return despachoRepository.save(despacho);
    }

    public Despacho update(Integer id, Despacho despachoActualizado) {
        Despacho existente = despachoRepository.findById(id).orElse(null);
        if (existente == null) {
            return null;
        }

        existente.setEstadoDespacho(despachoActualizado.getEstadoDespacho());
        existente.setDireccionDespacho(despachoActualizado.getDireccionDespacho());
        existente.setResponsableDespacho(despachoActualizado.getResponsableDespacho());
        existente.setFechaSalida(despachoActualizado.getFechaSalida());
        existente.setFechaEntrega(despachoActualizado.getFechaEntrega());
        existente.setQuienRecibe(despachoActualizado.getQuienRecibe());
        //existente.setSolicitud(despachoActualizado.getSolicitud());

        return despachoRepository.save(existente);
    }



}
