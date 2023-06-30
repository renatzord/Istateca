package com.istateca.app.istateca.services;

import com.istateca.app.istateca.models.Tipo;

import java.util.List;

public interface TipoService extends BaseService<Tipo, Integer> {

    public List<Tipo> tipoxnombre(String nombre);

}
