package com.istateca.app.istateca.services;

import com.istateca.app.istateca.models.Persona;

public interface PersonaService extends BaseService<Persona, Integer> {

    public Persona personaxCedula(String cedula);

}
