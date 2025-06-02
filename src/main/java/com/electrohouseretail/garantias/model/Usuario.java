package com.electrohouseretail.garantias.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 20, unique = true)
    private String username;

    @Column(nullable = false, length = 20, unique = false)
    private String password;

    @Column(nullable = false, length = 10, unique = false)
    private String rut;

    @Column(nullable = false, length = 15, unique = false)
    private String nombre;

    @Column(nullable = false, length = 20, unique = false)
    private String apellidoPaterno;

    @Column(nullable = false, length = 20, unique = false)
    private String apellidoMaterno;

    @Column(nullable = false, length = 40, unique = false)
    private String correo;

    @Column(nullable = false, length = 11, unique = false)
    private Integer telefono;

    @Column(nullable = false, length = 50, unique = false)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "rol", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Rol rol;


}
