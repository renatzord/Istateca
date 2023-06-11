package com.istateca.app.istateca.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Table(name = "libro")
public class Libro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lib_id")
    private Integer id;

    @NotEmpty(message = "Codigo DEWEY obligatorio.")
    @Column(name = "lib_codigo_DEWEY")
    private String codigoDewey;

    @NotEmpty(message = "Titulo requerido.")
    @Column(name = "lib_titulo")
    private String titulo;

    @Column(name = "lib_adquisicion")
    private String adquisicion;

    @NotEmpty(message = "Requiere año de publicacion.")
    @Column(name = "lib_anio_publicacion")
    private Integer anioPublicacion;

    @NotEmpty(message = "Requiere editor.")
    @Column(name = "lib_editor")
    private String editor;

    @NotEmpty(message = "Requiere ciudad de publicacion.")
    @Column(name = "lib_ciudad")
    private String ciudad;

    @NotEmpty(message = "Requiere numero de paginas.")
    @Column(name = "lib_num_paginas")
    private Integer numPaginas;

    @NotEmpty(message = "Se requiere area.")
    @Column(name = "lib_area")
    private String area;

    @NotEmpty(message = "Requiere codigo ISBN.")
    @Column(name = "lib_cod_ISBN")
    private String conIsbn;

    @Column(name = "lib_idioma")
    private String idioma;

    @Column(name = "lib_indice_uno")
    private String indiceUno;

    @Column(name = "lib_indice_dos")
    private String indiceDos;

    @Column(name = "lib_indice_Tres")
    private String indiceTres;

    @Column(name = "lib_descripcion")
    private String descripcion;

    @Pattern(regexp = "\\d{1,2}x\\d{1,2}")
    @Column(name = "lib_dimenciones")
    private String dimenciones;

    @NotEmpty(message = "Requiere estado.")
    @Column(name = "lib_estado_libro")
    private Integer estadoLibro;

    @Column(name = "lib_nombre_donante")
    private String nombreDonante;

    @Column(name = "lib_activo")
    private Boolean activo;

    @Column(name = "lib_url_imagen")
    private String urlImagen;

    @Column(name = "lib_url_acta_donacion")
    private String urlActaDonacion;

    @Column(name = "lib_url_digital")
    private String urlDigital;

    @Column(name = "lib_fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Timestamp fechaCreacion;

    @Column(name = "lib_disponibilidad")
    private Boolean disponibilidad;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "tip_id", referencedColumnName = "tip_id")
    private Tipo tipo;

    @ManyToOne
    @JoinColumn(name = "per_id_ingreso", referencedColumnName = "per_id")
    private Persona persona;

    // Bidirectional Relationships

    @JsonIgnore
    @OneToMany(mappedBy = "libro", fetch = FetchType.LAZY)
    private List<Prestamo> prestamos;

    @JsonIgnore
    @OneToMany(mappedBy = "libro", fetch = FetchType.LAZY)
    private List<AutorLibro> autoresLibro;


}
