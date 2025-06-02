package com.electrohouseretail.garantias.controller;

import com.electrohouseretail.garantias.model.Solicitud;
import com.electrohouseretail.garantias.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    @GetMapping("/api/v1/solicitud")
    public ResponseEntity<?> getSolicituds() {

        List<Solicitud> solicituds = solicitudService.findAll();
        return ResponseEntity.status(200).body(solicituds);

    }

    @GetMapping("/api/v1/solicitud/{id}")
    public ResponseEntity<?> getSolicitud(@PathVariable Integer id) {

        Solicitud solicitud = solicitudService.findById(id);

        if(solicitud == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(solicitud);

    }

    @DeleteMapping("/api/v1/solicitud/{id}")
    public ResponseEntity<?> deleteSolicitud(@PathVariable Integer id) {
        Solicitud solicitud = solicitudService.findById(id);
        if(solicitud == null) {
            return ResponseEntity.status(404).build();
        }
        solicitudService.delete(id);
        return ResponseEntity.status(200).body("Solicitud eliminada");
    }

    @PostMapping("/api/v1/solicitud")
    public ResponseEntity<?> crearSolicitud(@RequestBody Solicitud solicitud) {
        Solicitud nuevoSolicitud = solicitudService.save(solicitud);

        return ResponseEntity.status(201).body(nuevoSolicitud);
    }

    @GetMapping("/api/v1/seguimiento/{idUsuario}")
    public ResponseEntity<?> getSeguimientoPorUsuario(@PathVariable Integer idUsuario) {
        List<Solicitud> solicitudes = solicitudService.findByUsuarioId(idUsuario);
        return ResponseEntity.status(200).body(solicitudes);
    }

    @PutMapping("/api/v1/solicitud/{id}/reabrir")
    public ResponseEntity<?> reabrirSolicitud(@PathVariable Integer id) {
        Solicitud solicitud = solicitudService.reabrirSolicitud(id);
        if (solicitud == null) {
            return ResponseEntity.status(404).body("No se puede reabrir la solicitud");
        }
        return ResponseEntity.status(200).body(solicitud);
    }


}
