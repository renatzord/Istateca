package com.istateca.app.fenix.fservices;



import com.istateca.app.fenix.fmodels.UsuarioFenix;

import java.util.List;

public interface UsuarioFenixService {

    public List<UsuarioFenix> findAll();

    public UsuarioFenix findByCedula(String cedula);

    public UsuarioFenix findByCedulaEstudiante(String cedula);

    public List<UsuarioFenix> findByDocentes();



}
