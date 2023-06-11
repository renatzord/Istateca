package com.istateca.app.istateca.controllers;


import com.istateca.app.istateca.services.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public abstract class BaseController<T> {
    protected abstract BaseService<T,Integer> getService();
    public ResponseEntity<?> crear(@RequestBody T entity) {
        T savedEntity = getService().save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }
    public ResponseEntity<?> buscarID(@PathVariable("id") Integer id) {
        Optional<T> current = getService().findById(id);
        if (current.isPresent()) {
            return ResponseEntity.ok().body(current.get());
        }
        return ResponseEntity.notFound().build();
    }
    public ResponseEntity<List<T>> listar() {
        List<T> entities = getService().findAll();
        return ResponseEntity.ok().body(entities);
    }
}
