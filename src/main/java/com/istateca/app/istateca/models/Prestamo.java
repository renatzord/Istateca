package com.istateca.app.istateca.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "prestamo")
public class Prestamo implements Serializable,Actualizable<Prestamo> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pre_id")
    private Integer id;

    @Column(name = "pre_fecha_solicitud")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaFin;

    @NotNull(message = "Campo estado libro obligatorio.")
    @Column(name = "pre_estado_libro")
    private Integer estadoLibro;

    @NotNull(message = "Campo estado del prestamo obligatorio.")
    @Column(name = "pre_estado_prestamo")
    private Integer estadoPrestamo;

    @Column(name = "pre_fecha_entrega")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaEntrega;

    @Column(name = "pre_documento_habilitante")
    private Integer documentoHabilitante;

    @Column(name = "pre_fecha_devolucion")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaDevolucion;

    @NotNull(message = "Se nesesita fecha maxima de devolucion.")
    @Column(name = "pre_fecha_maxima")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaMaxima;

    @Column(name = "pre_activo", columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean activo;

    @Column(name = "pre_escaneo_matriz")
    private String escaneoMatriz;

    @NotNull(message = "Requiere tipo.")
    @Column(name = "pre_tipo_prestamo")
    private Integer tipoPrestamo;


    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "per_id_solicitante", referencedColumnName = "per_id")
    private Persona idSolicitante;

    @ManyToOne
    @JoinColumn(name = "per_id_entrega", referencedColumnName = "per_id")
    private Persona idEntrega;

    @ManyToOne
    @JoinColumn(name = "per_id_recibido", referencedColumnName = "per_id")
    private Persona idRecibido;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "car_id")
    private Carrera carrera;

    @ManyToOne
    @JoinColumn(name = "lib_id", referencedColumnName = "lib_id")
    private Libro libro;

    // Bidirectional Relationships

    @JsonIgnore
    @OneToMany(mappedBy = "prestamo", fetch = FetchType.LAZY)
    private List<Tercero> prestamosTerceros;

    @Override
    public void actualizarDatos(Prestamo entity) {
        if (entity.getFechaFin() != null) {
            this.setFechaFin(entity.getFechaFin());
        }
        if (entity.getEstadoLibro() != null) {
            this.setEstadoLibro(entity.getEstadoLibro());
        }
        if (entity.getEstadoPrestamo() != null) {
            this.setEstadoPrestamo(entity.getEstadoPrestamo());
        }
        if (entity.getFechaEntrega() != null) {
            this.setFechaEntrega(entity.getFechaEntrega());
        }
        if (entity.getDocumentoHabilitante() != null) {
            this.setDocumentoHabilitante(entity.getDocumentoHabilitante());
        }
        if (entity.getFechaDevolucion() != null) {
            this.setFechaDevolucion(entity.getFechaDevolucion());
        }
        if (entity.getFechaMaxima() != null) {
            this.setFechaMaxima(entity.getFechaMaxima());
        }
        if (entity.getActivo() != null) {
            this.setActivo(entity.getActivo());
        }
        if (entity.getEscaneoMatriz() != null) {
            this.setEscaneoMatriz(entity.getEscaneoMatriz());
        }
        if (entity.getTipoPrestamo() != null) {
            this.setTipoPrestamo(entity.getTipoPrestamo());
        }
    }
}
