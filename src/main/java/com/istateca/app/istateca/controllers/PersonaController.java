package com.istateca.app.istateca.controllers;

import com.istateca.app.istateca.models.Persona;
import com.istateca.app.istateca.services.BaseService;
import com.istateca.app.istateca.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/persona")
public class PersonaController extends BaseController<Persona> {

    @Autowired
    private PersonaService service;

    @Override
    protected BaseService<Persona, Integer> getService() {
        return service;
    }
/*
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editar(@PathVariable("id") Integer id, @RequestBody Persona entity) {
        Optional<Persona> optional = service.findById(id);
        if(optional.isPresent()) {
            Persona current = optional.get();
            current.setFenixId();
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(current));
        }else{
            String errorMessage = "No existe entidad con el ID: "+id;
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }*/
}
