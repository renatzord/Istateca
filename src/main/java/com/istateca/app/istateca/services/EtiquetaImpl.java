package com.istateca.app.istateca.services;

import com.istateca.app.istateca.daos.EtiquetaRepository;
import com.istateca.app.istateca.daos.BaseRepository;
import com.istateca.app.istateca.models.Etiqueta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EtiquetaImpl extends BaseServiceImpl<Etiqueta, Integer> implements EtiquetaService {

    @Autowired
    private EtiquetaRepository repository;

    public EtiquetaImpl(BaseRepository<Etiqueta, Integer> baseRepository) {
        super(baseRepository);
    }
}
