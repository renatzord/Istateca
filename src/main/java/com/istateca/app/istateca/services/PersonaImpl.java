package com.istateca.app.istateca.services;

import com.istateca.app.istateca.models.Persona;
import com.istateca.app.istateca.daos.BaseRepository;
import com.istateca.app.istateca.daos.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaImpl extends BaseServiceImpl<Persona, Integer> implements PersonaService {

    @Autowired
    private PersonaRepository repository;

    public PersonaImpl(BaseRepository<Persona, Integer> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Persona personaxCedula(String cedula) {
        return (Persona) repository.findByCedula(cedula).orElse(null);
    }
}
