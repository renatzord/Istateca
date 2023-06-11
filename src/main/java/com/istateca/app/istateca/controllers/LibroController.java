package com.istateca.app.istateca.controllers;

import com.istateca.app.istateca.models.Libro;
import com.istateca.app.istateca.services.BaseService;
import com.istateca.app.istateca.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/libro")
public class LibroController extends BaseController<Libro> {

    /*
    controladores basicos estan en controlador general
    crear: /libro/crear -> pasar requestbody
    listar: /libro/listar
    buscar: /libro/buscar/{id} -> pasar PathVariable("id")
    editar: /libro/editar/{id} -> pasar requestbody
    */

    @Autowired
    private LibroService service;

    @Override
    protected BaseService<Libro, Integer> getService() {
        return service;
    }
}
