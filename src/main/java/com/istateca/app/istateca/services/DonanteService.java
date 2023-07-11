package com.istateca.app.istateca.services;

import com.istateca.app.istateca.models.Donante;

import java.util.List;

public interface DonanteService extends BaseService<Donante, Integer> {

    public List<Donante> adonantesxNombre(String nombre);

}
