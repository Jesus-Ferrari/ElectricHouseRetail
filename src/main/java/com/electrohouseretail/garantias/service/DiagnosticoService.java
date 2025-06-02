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

}
