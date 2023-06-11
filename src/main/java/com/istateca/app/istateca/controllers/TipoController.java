package com.istateca.app.istateca.controllers;

import com.istateca.app.istateca.models.Tipo;
import com.istateca.app.istateca.services.BaseService;
import com.istateca.app.istateca.services.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipo")
public class TipoController extends BaseController<Tipo> {

    /*
    controladores basicos estan en controlador general
    crear: /tipo/crear -> pasar requestbody
    listar: /tipo/listar
    buscar: /tipo/buscar/{id} -> pasar PathVariable("id")
    editar: /tipo/editar/{id} -> pasar requestbody
    */

    @Autowired
    private TipoService service;

    @Override
    protected BaseService<Tipo, Integer> getService() {
        return service;
    }
}
