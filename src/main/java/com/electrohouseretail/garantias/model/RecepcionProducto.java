package com.electrohouseretail.garantias.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="recepcionProducto")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class RecepcionProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false, unique = false)
    private Date fechaRecepcion;

    @Column (nullable = false, length = 20, unique = false)
    private String estadoRecepcion;

    @Column (nullable = false, length = 30, unique = false)
    private String responsable;

    @ManyToOne
    @JoinColumn(name = "solicitud_id", nullable = false)
    private Solicitud solicitud;

}
