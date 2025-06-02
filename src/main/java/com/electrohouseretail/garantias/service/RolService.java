package com.electrohouseretail.garantias.service;

import com.electrohouseretail.garantias.model.Rol;
import com.electrohouseretail.garantias.repository.RolRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class RolService {

    @Autowired
    private RolRepository rolRepository;
    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    public Rol findById(Integer id) {
        return rolRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        rolRepository.deleteById(id);
    }

    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

    public Rol update(Integer id, Rol rolActualizado) {
        Rol existente = rolRepository.findById(id).orElse(null);
        if (existente == null) return null;

        existente.setTipoRol(rolActualizado.getTipoRol());
        return rolRepository.save(existente);
    }

}
