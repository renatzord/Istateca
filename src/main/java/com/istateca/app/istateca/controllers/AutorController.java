package com.istateca.app.istateca.controllers;

import com.istateca.app.istateca.models.Autor;
import com.istateca.app.istateca.services.AutorService;
import com.istateca.app.istateca.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/autor")
public class AutorController extends BaseController<Autor> {

    /*
    controladores basicos estan en controlador general
    crear: /autor/crear -> pasar requestbody
    listar: /autor/listar
    buscar: /autor/buscar/{id} -> pasar PathVariable("id")
    editar: /autor/editar/{id} -> pasar requestbody
    */

    @Autowired
    private AutorService service;

    @Override
    protected BaseService<Autor, Integer> getService() {
        return service;
    }
}
