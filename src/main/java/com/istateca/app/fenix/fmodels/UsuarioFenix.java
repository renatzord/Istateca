package com.istateca.app.fenix.fmodels;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "personas_istateca")
public class UsuarioFenix implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fenixid")
    private Integer alumno_docenteId;

    @Column(name = "cedula")
    private String cedula;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "celular")
    private String celular;

    @Column(name = "tipo")
    private Integer tipo;

    @Column(name = "carreraid")
    private Integer carreraid;

    @Column(name = "direccion")
    private String direccion;
}
