package com.electrohouseretail.garantias.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 20, unique = true)
    private Integer sku;

    @Column(nullable = false, length = 45, unique = false)
    private String nombreProducto;

    @Column(nullable = false, length = 25, unique = false)
    private String categoria;

    @Column(nullable = false, length = 5, unique = false)
    private Integer stock;

    @Column(nullable = false, length = 8, unique = false)
    private Integer monto;

}
