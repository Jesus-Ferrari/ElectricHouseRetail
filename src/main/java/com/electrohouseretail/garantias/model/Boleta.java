package com.electrohouseretail.garantias.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "boletas")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Boleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 20, unique = true)
    private Integer numeroBoleta;

    @Column(nullable = false, unique = false)
    private Date fechaBoleta;

    @Column(nullable = false, length = 8, unique = false)
    private Float iva;

    @Column(nullable = false, length = 8, unique = false)
    private Integer total;

}
