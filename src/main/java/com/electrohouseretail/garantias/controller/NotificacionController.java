package com.electrohouseretail.garantias.controller;

import com.electrohouseretail.garantias.model.Notificacion;
import com.electrohouseretail.garantias.model.Usuario;
import com.electrohouseretail.garantias.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    @GetMapping("/api/v1/notificacion")
    public ResponseEntity<?> getNotificacions() {

        List<Notificacion> notificacions = notificacionService.findAll();
        return ResponseEntity.status(200).body(notificacions);

    }

    @GetMapping("/api/v1/notificacion/{id}")
    public ResponseEntity<?> getNotificacion(@PathVariable Integer id) {

        Notificacion notificacion = notificacionService.findById(id);

        if(notificacion == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(notificacion);

    }

    @DeleteMapping("/api/v1/notificacion/{id}")
    public ResponseEntity<?> deleteNotificacion(@PathVariable Integer id) {
        Notificacion notificacion = notificacionService.findById(id);
        if(notificacion == null) {
            return ResponseEntity.status(404).build();
        }
        notificacionService.delete(id);
        return ResponseEntity.status(200).body("Notificacion eliminada");
    }

    @PostMapping("/api/v1/notificacion")
    public ResponseEntity<?> crearNotificacion(@RequestBody Notificacion notificacion) {
        Notificacion nuevoNotificacion = notificacionService.save(notificacion);

        return ResponseEntity.status(201).body(nuevoNotificacion);
    }


    @GetMapping("/api/v1/notificacion/solicitud/{idSolicitud}")
    public ResponseEntity<?> getNotificacionesPorSolicitud(@PathVariable Integer idSolicitud) {
        List<Notificacion> notificaciones = notificacionService.findBySolicitudId(idSolicitud);
        return ResponseEntity.status(200).body(notificaciones);
    }

    @PutMapping("/api/v1/notificacion/{id}")
    public ResponseEntity<?> updateNotificacion(@PathVariable Integer id, @RequestBody Notificacion notificacionActualizada) {
        Notificacion actualizada = notificacionService.update(id, notificacionActualizada);

        if (actualizada == null) {
            return ResponseEntity.status(404).body("Notificación no encontrada");
        }

        return ResponseEntity.status(200).body(actualizada);
    }

    @GetMapping("/api/v1/notificacion/usuario/{id}")
    public ResponseEntity<?> getByUsuarioId(@PathVariable Integer id) {
        List<Notificacion> notificaciones = notificacionService.findByUsuarioId(id);
        if (notificaciones.isEmpty()) {
            return ResponseEntity.status(404).body("No hay notificaciones para este usuario.");
        }
        return ResponseEntity.ok(notificaciones);
    }



}
