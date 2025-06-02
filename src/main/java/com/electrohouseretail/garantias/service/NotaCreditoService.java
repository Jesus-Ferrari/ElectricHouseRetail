package com.electrohouseretail.garantias.service;

import com.electrohouseretail.garantias.model.NotaCredito;
import com.electrohouseretail.garantias.repository.NotaCreditoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class NotaCreditoService {

    @Autowired
    private NotaCreditoRepository notaCreditoRepository;
    public List<NotaCredito> findAll() {
        return notaCreditoRepository.findAll();
    }

    public NotaCredito findById(Integer id) {
        return notaCreditoRepository.findById(id).orElse(null);
    }

    public NotaCredito save(NotaCredito notaCredito) {
        return notaCreditoRepository.save(notaCredito);
    }

}