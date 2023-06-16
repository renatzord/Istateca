package com.istateca.app.istateca.services;

import com.istateca.app.istateca.models.Persona;

public interface PersonaService extends BaseService<Persona, Integer> {

    public Persona personaxCedula(String cedula);

    Persona findByCorreo(String correo);

    boolean existsByCorreo(String correo);

}
