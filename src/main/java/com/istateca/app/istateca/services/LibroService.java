package com.istateca.app.istateca.services;

import com.istateca.app.istateca.models.Libro;

import java.util.List;

public interface LibroService extends BaseService<Libro, Integer> {

    public List<Libro> libroxTitulo(String titulo);

}
