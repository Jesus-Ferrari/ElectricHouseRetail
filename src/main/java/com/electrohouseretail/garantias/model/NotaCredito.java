package com.electrohouseretail.garantias.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "notasDeCredito")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class NotaCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 20, unique = true)
    private Integer numeroNC;

    @Column(nullable = false, length = 20, unique = false)
    private String tipoNC;

    @Column(nullable = false, length = 20, unique = true)
    private String folioSII;

    @Column(nullable = false, length = 20, unique = true)
    private Integer numeroTransBanc;

    @Column(nullable = false, unique = false)
    private Date fechaEmision;

    @Column(nullable = false, length = 10, unique = false)
    private Integer monto;

    @Column(nullable = false, length = 20, unique = false)
    private String metodoDevolucion;

    @Column(nullable = false, length = 20, unique = false)
    private String estadoNC;

}
