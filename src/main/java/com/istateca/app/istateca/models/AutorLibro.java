package com.istateca.app.istateca.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "autor_libro")
public class AutorLibro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ali_id")
    private Integer id;

    // Foreign Key - Relationships

    @ManyToOne
    @JoinColumn(name = "lib_id", referencedColumnName = "lib_id")
    private Libro libro;

    @ManyToOne
    @JoinColumn(name = "ato_id", referencedColumnName = "ato_id")
    private Autor autor;

}
