package com.electrohouseretail.garantias.service;


import com.electrohouseretail.garantias.model.Notificacion;
import com.electrohouseretail.garantias.repository.NotificacionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;
    public List<Notificacion> findAll() {
        return notificacionRepository.findAll();
    }

    public Notificacion findById(Integer id) {
        return notificacionRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        notificacionRepository.deleteById(id);
    }

    public Notificacion save(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    public List<Notificacion> findBySolicitudId(Integer id) {
        return notificacionRepository.findBySolicitudId(id);
    }

    public Notificacion update(Integer id, Notificacion notificacionActualizada) {
        Notificacion existente = notificacionRepository.findById(id).orElse(null);
        if (existente == null) {
            return null;
        }

        //existente.setFechaNotificacion(notificacionActualizada.getFechaNotificacion());
        existente.setMensaje(notificacionActualizada.getMensaje());
        //existente.setSolicitud(notificacionActualizada.getSolicitud());

        return notificacionRepository.save(existente);
    }

    public List<Notificacion> findByUsuarioId(Integer idUsuario) {
        return notificacionRepository.findBySolicitudUsuarioId(idUsuario);
    }


}
