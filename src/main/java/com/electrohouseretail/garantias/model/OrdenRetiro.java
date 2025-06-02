package com.electrohouseretail.garantias.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "ordenesDeRetiro")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrdenRetiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = false)
    private Date fechaRetiro;

    @Column(nullable = false, unique = false)
    private Date fechaLlegada;

    @Column(nullable = false, length = 20, unique = false)
    private String estadoRetiro;

}
