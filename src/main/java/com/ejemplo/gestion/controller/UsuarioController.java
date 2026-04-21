package com.ejemplo.gestion.controller;

import com.ejemplo.gestion.entity.Usuario;
import com.ejemplo.gestion.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    // ✅ LISTAR USUARIOS
    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    // ✅ BUSCAR POR ID
    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // ✅ REGISTRO
    @PostMapping("/registro")
    public Usuario registrar(@RequestBody Usuario usuario) {
        return service.registrar(usuario);
    }

    // ✅ LOGIN
    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario usuario) {
        return service.login(usuario.getEmail(), usuario.getPassword());
    }

    // ✅ ACTUALIZAR
    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return service.actualizar(id, usuario);
    }

    // ✅ INACTIVAR
    @PutMapping("/inactivar/{id}")
    public Usuario inactivar(@PathVariable Long id) {
        return service.inactivar(id);
    }

    // ✅ ELIMINAR
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}