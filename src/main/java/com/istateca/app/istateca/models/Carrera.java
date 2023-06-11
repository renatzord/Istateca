package com.istateca.app.istateca.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "carrera")
public class Carrera implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Integer id;

    @Column(name = "car_id_fenix", unique = true)
    private Integer idFenix;

    @Column(name = "car_nombre")
    private String nombre;

    @Column(name = "car_activo")
    private Boolean activo;

    // Bidirectional Relationships

    @JsonIgnore
    @OneToMany(mappedBy = "carrera", fetch = FetchType.LAZY)
    private List<Prestamo> prestamos;
}
