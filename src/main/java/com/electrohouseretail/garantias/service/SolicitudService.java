package com.electrohouseretail.garantias.service;

import com.electrohouseretail.garantias.model.Solicitud;
import com.electrohouseretail.garantias.repository.SolicitudRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;
    public List<Solicitud> findAll() {
        return solicitudRepository.findAll();
    }

    public Solicitud findById(Integer id) {
        return solicitudRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        solicitudRepository.deleteById(id);
    }

    public Solicitud save(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

    public List<Solicitud> findByUsuarioId(Integer id) {
        return solicitudRepository.findByUsuarioId(id);
    }

    public Solicitud reabrirSolicitud(Integer id) {
        Solicitud solicitud = solicitudRepository.findById(id).orElse(null);
        if (solicitud != null && solicitud.getEstadoSolicitud().equalsIgnoreCase("Cerrado")) {
            solicitud.setEstadoSolicitud("Pendiente"); // o "Reabierto"
            return solicitudRepository.save(solicitud);
        }
        return null;
    }



}
