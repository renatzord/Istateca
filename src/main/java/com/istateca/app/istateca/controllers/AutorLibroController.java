package com.istateca.app.istateca.controllers;

import com.istateca.app.istateca.models.AutorLibro;
import com.istateca.app.istateca.services.AutorLibroService;
import com.istateca.app.istateca.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autorlibro")
public class AutorLibroController extends BaseController<AutorLibro> {

    /*
    controladores basicos estan en controlador general
    crear: /autorlibro/crear -> pasa requestbody
    listar: /autorlibro/listar
    buscar: /autorlibro/buscarID -> pasa PathVariable("id")
    */

    @Autowired
    private AutorLibroService service;

    @Override
    protected BaseService<AutorLibro, Integer> getService() {
        return service;
    }


}
