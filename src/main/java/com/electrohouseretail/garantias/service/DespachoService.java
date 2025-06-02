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


}
