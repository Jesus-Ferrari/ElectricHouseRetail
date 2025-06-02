package com.electrohouseretail.garantias.service;

import com.electrohouseretail.garantias.model.OrdenRetiro;
import com.electrohouseretail.garantias.repository.OrdenRetiroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class OrdenRetiroService {

    @Autowired
    private OrdenRetiroRepository ordenRetiroRepository;
    public List<OrdenRetiro> findAll() {
        return ordenRetiroRepository.findAll();
    }

    public OrdenRetiro findById(Integer id) {
        return ordenRetiroRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        ordenRetiroRepository.deleteById(id);
    }

    public OrdenRetiro save(OrdenRetiro ordenRetiro) {
        return ordenRetiroRepository.save(ordenRetiro);
    }

    public OrdenRetiro update(Integer id, OrdenRetiro ordenActualizada) {
        OrdenRetiro existente = ordenRetiroRepository.findById(id).orElse(null);
        if (existente == null) {
            return null;
        }

        existente.setFechaRetiro(ordenActualizada.getFechaRetiro());
        existente.setFechaLlegada(ordenActualizada.getFechaLlegada());
        existente.setEstadoRetiro(ordenActualizada.getEstadoRetiro());

        return ordenRetiroRepository.save(existente);
    }


}
