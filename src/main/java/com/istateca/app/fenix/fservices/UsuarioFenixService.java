package com.istateca.app.fenix.fservices;



import com.istateca.app.fenix.fmodels.UsuarioFenix;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioFenixService {

    public List<UsuarioFenix> findAll();

    public UsuarioFenix findByCedula(String cedula);

    public UsuarioFenix findByCedulaEstudiante(String cedula);

    public List<UsuarioFenix> findByDocentes();
    public UsuarioFenix findByCorreo(String correo);

    UsuarioFenix findByNombresAndApellidosQuery(@Param("parametro") String parametro);

}
