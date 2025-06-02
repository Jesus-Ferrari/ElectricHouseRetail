package com.electrohouseretail.garantias.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="despacho")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Despacho {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length =30,  unique = false)
    private String estadoDespacho;

    @Column(nullable = false, length =50,  unique = false)
    private String direccionDespacho;

    @Column(nullable = false, length =30,  unique = false)
    private String responsableDespacho;

    @Column(nullable = false, unique = false)
    private Date fechaSalida;

    @Column(nullable = false, unique = false)
    private Date fechaEntrega;

    @Column(nullable = false, length =30,  unique = false)
    private String quienRecibe;

    @ManyToOne
    @JoinColumn(name = "solicitud_id", nullable = false)
    private Solicitud solicitud;

}
