package com.istateca.app.istateca.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "prestamo")
public class Prestamo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pre_id")
    private Integer id;

    @Column(name = "pre_fecha_solicitud")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Timestamp fechaFin;

    @NotEmpty(message = "Campo estado libro obligatorio.")
    @Column(name = "pre_estado_libro")
    private Integer estadoLibro;

    @NotEmpty(message = "Campo estado del prestamo obligatorio.")
    @Column(name = "pre_estado_prestamo")
    private Integer estadoPrestamo;

    @Column(name = "pre_fecha_entrega")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Timestamp fechaEntrega;

    @Column(name = "pre_documento_habilitante")
    private Integer documentoHabilitante;

    @Column(name = "pre_fecha_devolucion")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Timestamp fechaDevolucion;

    @NotEmpty(message = "Se nesesita fecha maxima de devolucion.")
    @Column(name = "pre_fecha_maxima")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaMaxima;

    @Column(name = "pre_activo", columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean activo;

    @Column(name = "pre_escaneo_matriz")
    private String escaneoMatriz;

    @NotEmpty(message = "Requiere tipo.")
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
}
