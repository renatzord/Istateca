package com.istateca.app.istateca.controllers;

import com.istateca.app.istateca.models.Prestamo;
import com.istateca.app.istateca.services.BaseService;
import com.istateca.app.istateca.services.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prestamo")
public class PrestamoController  extends BaseController<Prestamo> {

        /*
    controladores basicos estan en controlador general
    crear: /prestamo/crear -> pasar requestbody
    listar: /prestamo/listar
    buscar: /prestamo/buscar/{id} -> pasar PathVariable("id")
    editar: /prestamo/editar/{id} -> pasar requestbody
    */

    @Autowired
    private PrestamoService service;

    @Override
    protected BaseService<Prestamo, Integer> getService() {
        return service;
    }

    public List<Prestamo> prestamosxestado(@RequestParam(value = "parametro") Integer parametro) {
        return service.prestamoxestadoprestamo(parametro);
    }
}
