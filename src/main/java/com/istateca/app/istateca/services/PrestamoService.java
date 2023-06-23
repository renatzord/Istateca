package com.istateca.app.istateca.services;

import com.istateca.app.istateca.models.Prestamo;

import java.util.Date;
import java.util.List;

public interface PrestamoService extends BaseService<Prestamo, Integer> {

    public List<Prestamo> prestamoxestadoprestamo(Integer estado);

    public List<Prestamo> prestamoxcedula(String cedula);

    public List<Prestamo> prestamopasados(Date fechaActual);

}
