package com.istateca.app.istateca.controllers;

import com.istateca.app.istateca.models.Prestamo;
import com.istateca.app.istateca.services.BaseService;
import com.istateca.app.istateca.services.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
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

    @GetMapping("/listarxestado")
    public ResponseEntity<List<Prestamo>> prestamosxestado(@RequestParam(value = "parametro") Integer parametro) {
        List<Prestamo> prestamos = service.prestamoxestadoprestamo(parametro);
        if (prestamos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(prestamos);
        }
    }

    @GetMapping("/listarxcedula")
    public ResponseEntity<List<Prestamo>> prestamosxcedula(@RequestParam(value = "cedula") String cedula) {
        List<Prestamo> prestamos = service.prestamoxcedula(cedula);
        if (prestamos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(prestamos);
        }
    }

    @GetMapping("/listarpasados")
    public ResponseEntity<List<Prestamo>> prestamospasados() {
        LocalDate localDate = LocalDate.now();
        Date date = java.sql.Date.valueOf(localDate);
        List<Prestamo> prestamos = service.prestamopasados(date);
        if (prestamos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(prestamos);
        }
    }
}
