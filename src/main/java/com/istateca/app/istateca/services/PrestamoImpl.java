package com.istateca.app.istateca.services;

import com.istateca.app.istateca.daos.PrestamoRepository;
import com.istateca.app.istateca.daos.BaseRepository;
import com.istateca.app.istateca.models.Prestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrestamoImpl extends BaseServiceImpl<Prestamo, Integer> implements PrestamoService {

    @Autowired
    private PrestamoRepository repository;

    public PrestamoImpl(BaseRepository<Prestamo, Integer> baseRepository) {
        super(baseRepository);
    }
}
