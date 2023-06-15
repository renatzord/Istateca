package com.istateca.app.istateca.controllers;

import com.istateca.app.istateca.models.Etiqueta;
import com.istateca.app.istateca.services.EtiquetaService;
import com.istateca.app.istateca.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/etiqueta")
public class EtiquetaController extends BaseController<Etiqueta> {

    /*
    controladores basicos estan en controlador general
    crear: /etiqueta/crear -> pasar requestbody
    listar: /etiqueta/listar
    buscar: /etiqueta/buscar/{id} -> pasar PathVariable("id")
    editar: /etiqueta/editar/{id} -> pasar requestbody
    */

    @Autowired
    private EtiquetaService service;

    @Override
    protected BaseService<Etiqueta, Integer> getService() {
        return service;
    }
}
