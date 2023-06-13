package com.istateca.app.istateca.daos;

import com.istateca.app.istateca.models.Persona;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends BaseRepository<Persona,Integer>{

    Optional<Persona> findByCedula(String cedula);

}
