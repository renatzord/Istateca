package com.istateca.app.istateca.controllers;

import com.istateca.app.istateca.models.EtiquetaLibro;
import com.istateca.app.istateca.services.BaseService;
import com.istateca.app.istateca.services.EtiquetaLibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
public class EtiquetaLibroController extends BaseController<EtiquetaLibro> {

    /*
    controladores basicos estan en controlador general
    crear: /autor/crear -> pasar requestbody
    listar: /autor/listar
    buscar: /autor/buscar/{id} -> pasar PathVariable("id")
    editar: /autor/editar/{id} -> pasar requestbody
    */

    @Autowired
    private EtiquetaLibroService service;

    @Override
    protected BaseService<EtiquetaLibro, Integer> getService() {
        return service;
    }
}
