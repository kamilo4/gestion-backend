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

    // ✅ REGISTRAR USUARIO
    public Usuario registrar(Usuario u) {
        return repo.save(u);
    }

    // ✅ LISTAR USUARIOS
    public List<Usuario> listar() {
        return repo.findAll();
    }

    // ✅ LOGIN
    public Usuario login(String email, String password) {
        return repo.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new RuntimeException("Credenciales incorrectas"));
    }

    // ✅ BUSCAR POR ID
    public Usuario buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    // ✅ ACTUALIZAR USUARIO
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

    // ✅ INACTIVAR USUARIO
    public Usuario inactivar(Long id) {
        Usuario u = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        u.setActivo(false);
        return repo.save(u);
    }

    // ✅ ELIMINAR USUARIO
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}