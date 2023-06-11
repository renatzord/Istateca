package com.istateca.app.istateca.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "per_id")
    private Integer id;

    @Column(name = "per_fenix_id", unique = true)
    private Integer fenixId;

    @NotEmpty(message = "Campo de cedula obligatorio.")
    @Column(name = "per_cedula")
    private String cedula;

    @Email(message = "No corresponde a un Email.")
    @Column(name = "per_correo")
    private String correo;

    @NotEmpty(message = "Campo nombre obligatorio.")
    @Column(name = "per_nombres")
    private String nombres;

    @NotEmpty(message = "Campo apellido obligatorio.")
    @Column(name = "per_apellidos")
    private String apellidos;

    @Column(name = "per_tipo")
    private Integer tipo;

    @Pattern(regexp = "\\d+", message = "El teléfono debe contar solo con números")
    @Column(name = "per_celular")
    private String celular;

    @Column(name = "per_calificacion")
    @Min(0) @Max(5)
    private Integer calificacion;

    @Column(name = "per_activo")
    private Boolean activo;

    // Bidirectional Relationships

    @JsonIgnore
    @OneToOne(mappedBy = "persona", fetch = FetchType.EAGER)
    private Authority authorities;

    @JsonIgnore
    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    private List<BibliotecarioCargo> bibliotecaCargos;

    @JsonIgnore
    @OneToMany(mappedBy = "idSolicitante", fetch = FetchType.LAZY)
    private List<Prestamo> solicitudesPrestamo;

    @JsonIgnore
    @OneToMany(mappedBy = "idEntrega", fetch = FetchType.LAZY)
    private List<Prestamo> prestamosEntregados;

    @JsonIgnore
    @OneToMany(mappedBy = "idRecibido", fetch = FetchType.LAZY)
    private List<Prestamo> prestamosRecibidos;

    @JsonIgnore
    @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
    private List<Libro> librosIngresados;

}
