package com.istateca.app.istateca.daos;

import com.istateca.app.istateca.models.Prestamo;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PrestamoRepository extends BaseRepository<Prestamo,Integer>{

    List<Prestamo> findAllByEstadoPrestamo(Integer estado);

    List<Prestamo> findAllByIdSolicitanteCedula(String cedula);

    List<Prestamo> findByFechaMaximaLessThanAndEstadoPrestamo(Date fechaActual,Integer estado);

}
