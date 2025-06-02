package com.electrohouseretail.garantias.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "diagnosticos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 20, unique = false)
    private String tipoDiagnostico;

    @Column(nullable = false, length = 300, unique = false)
    private String descripcion;

    @Column(nullable = false, length = 30, unique = false)
    private String responsable;

    @Column(nullable = false, unique = false)
    private Date fechaDiagnostico;

}
