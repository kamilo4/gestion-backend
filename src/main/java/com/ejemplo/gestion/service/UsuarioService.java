package com.ejemplo.gestion.service;

import com.ejemplo.gestion.entity.Usuario;
import com.ejemplo.gestion.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    // =========================
    // REGISTRAR USUARIO
    // =========================
    public Usuario registrar(Usuario u) {

        // Validar nombre
        if (u.getNombre() == null || u.getNombre().isEmpty()) {
            throw new RuntimeException("El nombre es obligatorio");
        }

        // Validar email
        if (u.getEmail() == null || u.getEmail().isEmpty()) {
            throw new RuntimeException("El email es obligatorio");
        }

        // Validar password
        if (u.getPassword() == null || u.getPassword().length() < 6) {
            throw new RuntimeException("La contraseña debe tener mínimo 6 caracteres");
        }

        // Verificar si el email ya existe
        if (repo.findByEmail(u.getEmail()).isPresent()) {
            throw new RuntimeException("El correo ya está registrado");
        }

        return repo.save(u);
    }

    // =========================
    // LISTAR USUARIOS
    // =========================
    public List<Usuario> listar() {
        return repo.findAll();
    }

    // =========================
    // LOGIN
    // =========================
    public Usuario login(String email, String password) {

        if (email == null || password == null) {
            throw new RuntimeException("Email y contraseña son obligatorios");
        }

        return repo.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new RuntimeException("Credenciales incorrectas"));
    }

    // =========================
    // BUSCAR POR ID
    // =========================
    public Usuario buscarPorId(Long id) {

        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    // =========================
    // ACTUALIZAR USUARIO
    // =========================
    public Usuario actualizar(Long id, Usuario nuevo) {

        Usuario u = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        u.setNombre(nuevo.getNombre());
        u.setEmail(nuevo.getEmail());
        u.setPassword(nuevo.getPassword());
        u.setTelefono(nuevo.getTelefono());
        u.setActivo(nuevo.isActivo());

        return repo.save(u);
    }

    // =========================
    // INACTIVAR USUARIO
    // =========================
    public Usuario inactivar(Long id) {

        Usuario u = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        u.setActivo(false);

        return repo.save(u);
    }

    // =========================
    // ELIMINAR USUARIO
    // =========================
    public void eliminar(Long id) {

        Usuario u = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        repo.delete(u);
    }

    // =========================
    // USUARIOS ACTIVOS
    // =========================
    public List<Usuario> usuariosActivos() {

        return repo.findByActivo(true);
    }

    // =========================
    // BUSCAR POR NOMBRE
    // =========================
    public List<Usuario> buscarPorNombre(String nombre) {

        return repo.findByNombreContainingIgnoreCase(nombre);
    }
}
