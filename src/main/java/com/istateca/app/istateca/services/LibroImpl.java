package com.istateca.app.istateca.services;

import com.istateca.app.istateca.daos.LibroRepository;
import com.istateca.app.istateca.daos.BaseRepository;
import com.istateca.app.istateca.models.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroImpl extends BaseServiceImpl<Libro, Integer> implements LibroService {

    @Autowired
    private LibroRepository repository;

    public LibroImpl(BaseRepository<Libro, Integer> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Libro> libroxTitulo(String titulo) {
        return repository.findAllByTituloLike(titulo);
    }
}
