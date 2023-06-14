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
public class Libro implements Serializable,Actualizable<Libro> {

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

    @Override
    public void actualizarDatos(Libro entity) {
        if (entity.getCodigoDewey() != null) {
            this.setCodigoDewey(entity.getCodigoDewey());
        }
        if (entity.getTitulo() != null) {
            this.setTitulo(entity.getTitulo());
        }
        if (entity.getAdquisicion() != null) {
            this.setAdquisicion(entity.getAdquisicion());
        }
        if (entity.getAnioPublicacion() != null) {
            this.setAnioPublicacion(entity.getAnioPublicacion());
        }
        if (entity.getEditor() != null) {
            this.setEditor(entity.getEditor());
        }
        if (entity.getCiudad() != null) {
            this.setCiudad(entity.getCiudad());
        }
        if (entity.getNumPaginas() != null) {
            this.setNumPaginas(entity.getNumPaginas());
        }
        if (entity.getArea() != null) {
            this.setArea(entity.getArea());
        }
        if (entity.getConIsbn() != null) {
            this.setConIsbn(entity.getConIsbn());
        }
        if (entity.getIdioma() != null) {
            this.setIdioma(entity.getIdioma());
        }
        if (entity.getIndiceUno() != null) {
            this.setIndiceUno(entity.getIndiceUno());
        }
        if (entity.getIndiceDos() != null) {
            this.setIndiceDos(entity.getIndiceDos());
        }
        if (entity.getIndiceTres() != null) {
            this.setIndiceTres(entity.getIndiceTres());
        }
        if (entity.getDescripcion() != null) {
            this.setDescripcion(entity.getDescripcion());
        }
        if (entity.getDimenciones() != null) {
            this.setDimenciones(entity.getDimenciones());
        }
        if (entity.getEstadoLibro() != null) {
            this.setEstadoLibro(entity.getEstadoLibro());
        }
        if (entity.getNombreDonante() != null) {
            this.setNombreDonante(entity.getNombreDonante());
        }
        if (entity.getActivo() != null) {
            this.setActivo(entity.getActivo());
        }
        if (entity.getUrlImagen() != null) {
            this.setUrlImagen(entity.getUrlImagen());
        }
        if (entity.getUrlActaDonacion() != null) {
            this.setUrlActaDonacion(entity.getUrlActaDonacion());
        }
        if (entity.getUrlDigital() != null) {
            this.setUrlDigital(entity.getUrlDigital());
        }
        if (entity.getFechaCreacion() != null) {
            this.setFechaCreacion(entity.getFechaCreacion());
        }
        if (entity.getDisponibilidad() != null) {
            this.setDisponibilidad(entity.getDisponibilidad());
        }
        if (entity.getTipo() != null) {
            this.setTipo(entity.getTipo());
        }
        if (entity.getPersona() != null) {
            this.setPersona(entity.getPersona());
        }
    }

}