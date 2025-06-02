package com.electrohouseretail.garantias.service;

import com.electrohouseretail.garantias.model.Notificacion;
import com.electrohouseretail.garantias.model.Solicitud;
import com.electrohouseretail.garantias.model.Usuario;
import com.electrohouseretail.garantias.repository.NotificacionRepository;
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

    @Autowired
    private NotificacionRepository notificacionRepository;

    public List<Solicitud> findAll() {
        return solicitudRepository.findAll();
    }

    public Solicitud findById(Integer id) {
        return solicitudRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        List<Notificacion> notificaciones = notificacionRepository.findBySolicitudId(id);
        notificacionRepository.deleteAll(notificaciones);
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

    public Solicitud update(Integer id, Solicitud solicitudActualizada) {
        Solicitud solicitudExistente = solicitudRepository.findById(id).orElse(null);
        if (solicitudExistente == null) {
            return null;
        }

        solicitudExistente.setTipoSolicitud(solicitudActualizada.getTipoSolicitud());
        solicitudExistente.setDescripcion(solicitudActualizada.getDescripcion());
        //solicitudExistente.setFechaSolicitud(solicitudActualizada.getFechaSolicitud());
        solicitudExistente.setEstadoSolicitud(solicitudActualizada.getEstadoSolicitud());
        //solicitudExistente.setRutaBoleta(solicitudActualizada.getRutaBoleta());
        //solicitudExistente.setRutaDeclaracion(solicitudActualizada.getRutaDeclaracion());
        //solicitudExistente.setUsuario(solicitudActualizada.getUsuario());

        return solicitudRepository.save(solicitudExistente);
    }




}
