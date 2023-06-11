package com.istateca.app.istateca.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "tercero")
public class Tercero implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ter_id")
    private Integer id;

    @NotEmpty(message = "Campo cedula obligatorio.")
    @Pattern(regexp = "^\\d{10}$", message = "La cédula debe contener exactamente 10 dígitos.")
    @Column(name = "ter_cedula")
    private String cedula;

    @Email(message = "No corresponde a un Email.")
    @Column(name = "ter_correo")
    private String correo;

    @NotEmpty(message = "Nombre obligatorio.")
    @Column(name = "ter_nombre")
    private String nombre;

    @Pattern(regexp = "\\d+", message = "El teléfono debe contar solo con números")
    @Column(name = "ter_telefono")
    private String telefono;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "pre_id", referencedColumnName = "pre_id")
    private Prestamo prestamo;

}
