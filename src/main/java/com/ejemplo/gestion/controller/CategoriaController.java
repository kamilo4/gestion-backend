package com.ejemplo.gestion.controller;

import com.ejemplo.gestion.entity.Categoria;
import com.ejemplo.gestion.service.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    // ✅ LISTAR
    @GetMapping
    public List<Categoria> listar() {
        return service.listar();
    }

    // ✅ CREAR
    @PostMapping
    public Categoria crear(@RequestBody Categoria c) {
        return service.guardar(c);
    }

    // ✅ ACTUALIZAR
    @PutMapping("/{id}")
    public Categoria actualizar(@PathVariable Long id, @RequestBody Categoria c) {
        return service.actualizar(id, c);
    }

    // ✅ ELIMINAR
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}