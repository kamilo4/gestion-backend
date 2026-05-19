package com.ejemplo.gestion.repository;

import com.ejemplo.gestion.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Buscar por email
    Optional<Usuario> findByEmail(String email);

    // Login
    Optional<Usuario> findByEmailAndPassword(String email, String password);

    // Buscar usuarios activos
    List<Usuario> findByActivo(boolean activo);

    // Buscar usuarios por nombre
    List<Usuario> findByNombreContainingIgnoreCase(String nombre);
}
