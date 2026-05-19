package com.ejemplo.gestion.repositorio;

import com.ejemplo.gestion.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Buscar usuario por email y password
    Optional<Usuario> encontrarPorCorreoElectronicoYPassword(String email, String password);

    // Buscar usuario por email
    Optional<Usuario> encontrarPorCorreoElectronico(String email);

    // Obtener usuarios activos
    List<Usuario> findByActivoTrue();

    // Buscar por email
    Optional<Usuario> findByEmail(String email);

}
