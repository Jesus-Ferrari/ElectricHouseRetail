package com.electrohouseretail.garantias.service;

import com.electrohouseretail.garantias.model.Diagnostico;
import com.electrohouseretail.garantias.repository.DiagnosticoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class DiagnosticoService {

    @Autowired
    private DiagnosticoRepository diagnosticoRepository;
    public List<Diagnostico> findAll() {
        return diagnosticoRepository.findAll();
    }

    public Diagnostico findById(Integer id) {
        return diagnosticoRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        diagnosticoRepository.deleteById(id);
    }

    public Diagnostico save(Diagnostico diagnostico) {
        return diagnosticoRepository.save(diagnostico);
    }

    public Diagnostico update(Integer id, Diagnostico diagnosticoActualizado) {
        Diagnostico existente = diagnosticoRepository.findById(id).orElse(null);
        if (existente == null) {
            return null;
        }

        existente.setTipoDiagnostico(diagnosticoActualizado.getTipoDiagnostico());
        existente.setDescripcion(diagnosticoActualizado.getDescripcion());
        existente.setResponsable(diagnosticoActualizado.getResponsable());
        existente.setFechaDiagnostico(diagnosticoActualizado.getFechaDiagnostico());

        return diagnosticoRepository.save(existente);
    }

}
