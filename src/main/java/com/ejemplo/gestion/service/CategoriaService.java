package com.ejemplo.gestion.service;

import com.ejemplo.gestion.entity.Categoria;
import com.ejemplo.gestion.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository repo;

    public CategoriaService(CategoriaRepository repo) {
        this.repo = repo;
    }

    // ✅ LISTAR
    public List<Categoria> listar() {
        return repo.findAll();
    }

    // ✅ CREAR
    public Categoria guardar(Categoria c) {
        return repo.save(c);
    }

    // ✅ ACTUALIZAR
    public Categoria actualizar(Long id, Categoria nueva) {
        Categoria c = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));

        c.setNombre(nueva.getNombre());
        return repo.save(c);
    }

    // ✅ ELIMINAR
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
