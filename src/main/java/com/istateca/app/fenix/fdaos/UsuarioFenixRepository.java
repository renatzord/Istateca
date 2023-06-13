package com.istateca.app.fenix.fdaos;


import com.istateca.app.fenix.fmodels.UsuarioFenix;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioFenixRepository extends CrudRepository<UsuarioFenix,Integer> {

    Optional<UsuarioFenix> findByCedula(String cedula);

    Optional<UsuarioFenix> findByCedulaAndTipo(String cedula,Integer tipo);

    Optional<List<UsuarioFenix>> findByTipo(Integer tipo);

}
