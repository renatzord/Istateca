package com.istateca.app.istateca.services;

import com.istateca.app.istateca.models.Libro;

import java.util.List;

public interface LibroService extends BaseService<Libro, Integer> {

    public List<Libro> librosxTitulo(String titulo);
    public List<Libro> librosxTipo(Integer tipo);
    public  List<Libro> librosxcoincidencias(String parametro);

}
