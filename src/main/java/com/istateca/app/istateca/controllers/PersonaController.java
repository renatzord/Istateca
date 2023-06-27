package com.istateca.app.istateca.controllers;

import com.istateca.app.istateca.models.Persona;
import com.istateca.app.istateca.services.BaseService;
import com.istateca.app.istateca.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/persona")
public class PersonaController extends BaseController<Persona> {

    /*
    controladores basicos estan en controlador general
    crear: /persona/crear -> pasar requestbody
    listar: /persona/listar
    buscar: /persona/buscar/{id} -> pasar PathVariable("id")
    editar: /persona/editar/{id} -> pasar requestbody
    */

    @Autowired
    private PersonaService service;

    @Override
    protected BaseService<Persona, Integer> getService() {
        return service;
    }

    @GetMapping("/personaxcedula/{cedula}")
    public ResponseEntity<Persona> personaxcedula(@PathVariable String cedula) {
        Persona persona = service.personaxCedula(cedula);
        if (persona == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(persona);
        }
    }
}
