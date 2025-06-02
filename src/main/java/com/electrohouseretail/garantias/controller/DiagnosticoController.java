package com.electrohouseretail.garantias.controller;

import com.electrohouseretail.garantias.model.Diagnostico;
import com.electrohouseretail.garantias.service.DiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class DiagnosticoController {

    @Autowired
    private DiagnosticoService diagnosticoService;

    @GetMapping("/api/v1/diagnostico")
    public ResponseEntity<?> getDiagnosticos() {

        List<Diagnostico> diagnosticos = diagnosticoService.findAll();
        return ResponseEntity.status(200).body(diagnosticos);

    }

    @GetMapping("/api/v1/diagnostico/{id}")
    public ResponseEntity<?> getDiagnostico(@PathVariable Integer id) {

        Diagnostico diagnostico = diagnosticoService.findById(id);

        if(diagnostico == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(diagnostico);

    }

    @DeleteMapping("/api/v1/diagnostico/{id}")
    public ResponseEntity<?> deleteDiagnostico(@PathVariable Integer id) {
        Diagnostico diagnostico = diagnosticoService.findById(id);
        if(diagnostico == null) {
            return ResponseEntity.status(404).build();
        }
        diagnosticoService.delete(id);
        return ResponseEntity.status(200).body("Diagnostico eliminado");
    }

    @PostMapping("/api/v1/diagnostico")
    public ResponseEntity<?> crearDiagnostico(@RequestBody Diagnostico diagnostico) {
        Diagnostico nuevoDiagnostico = diagnosticoService.save(diagnostico);

        return ResponseEntity.status(201).body(nuevoDiagnostico);
    }

}

