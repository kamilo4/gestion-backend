package com.ejemplo.gestion.repository;

import com.ejemplo.gestion.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}