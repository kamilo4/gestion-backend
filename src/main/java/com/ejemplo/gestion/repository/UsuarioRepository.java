package com.ejemplo.gestion.repository;

import com.ejemplo.gestion.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Buscar usuario por email y password (login)
    Optional<Usuario> findByEmailAndPassword(String email, String password);

    // (Opcional pero recomendado) Buscar solo por email
    Optional<Usuario> findByEmail(String email);
}