package com.istateca.app.istateca.services;

import com.istateca.app.istateca.models.Autor;
import com.istateca.app.istateca.daos.AutorRepository;
import com.istateca.app.istateca.daos.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorImpl extends BaseServiceImpl<Autor, Integer> implements AutorService{

    @Autowired
    private AutorRepository repository;

    public AutorImpl(BaseRepository<Autor, Integer> baseRepository) {
        super(baseRepository);
    }
}
