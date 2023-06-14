package com.istateca.app.istateca.daos;

import com.istateca.app.istateca.models.Libro;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends BaseRepository<Libro,Integer>{

    List<Libro> findAllByTituloContaining(String titulo);

}
