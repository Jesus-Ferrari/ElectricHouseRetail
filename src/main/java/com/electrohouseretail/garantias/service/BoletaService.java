package com.electrohouseretail.garantias.service;

import com.electrohouseretail.garantias.model.Boleta;
import com.electrohouseretail.garantias.repository.BoletaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class BoletaService {

    @Autowired
    private BoletaRepository boletaRepository;
    public List<Boleta> findAll() {
        return boletaRepository.findAll();
    }

    public Boleta findById(Integer id) {
        return boletaRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        boletaRepository.deleteById(id);
    }

    public Boleta save(Boleta boleta) {
        return boletaRepository.save(boleta);
    }

    public Boleta update(Integer id, Boleta boletaActualizada) {
        Boleta existente = boletaRepository.findById(id).orElse(null);
        if (existente == null) {
            return null;
        }

        //existente.setNumeroBoleta(boletaActualizada.getNumeroBoleta());
        existente.setFechaBoleta(boletaActualizada.getFechaBoleta());
        //existente.setIva(boletaActualizada.getIva());
        existente.setTotal(boletaActualizada.getTotal());

        return boletaRepository.save(existente);
    }


}