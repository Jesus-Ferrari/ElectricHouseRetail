package com.electrohouseretail.garantias.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "solicitudes")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 20, unique = false)
    private String tipoSolicitud;

    @Column(nullable = false, length = 300, unique = false)
    private String descripcion;

    @Column(nullable = false, unique = false)
    private Date fechaSolicitud;

    @Column(nullable = false, length = 20, unique = false)
    private String estadoSolicitud;

    @Column(nullable = false, length = 50, unique = false)
    private String rutaBoleta;

    @Column(nullable = false, length = 50, unique = false)
    private String rutaDeclaracion;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonIgnoreProperties("solicitudes") // para evitar loops en JSON
    private Usuario usuario;

}
