package com.ejemplo.gestion.controller;

import com.ejemplo.gestion.entity.Usuario;
import com.ejemplo.gestion.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // =========================
    // REGISTRAR USUARIO
    // =========================
    @PostMapping("/registro")
    public ResponseEntity<?> registrar(@RequestBody Usuario usuario) {

        try {
            Usuario nuevo = usuarioService.registrar(usuario);
            return ResponseEntity.ok(nuevo);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // =========================
    // LISTAR USUARIOS
    // =========================
    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {

        return ResponseEntity.ok(usuarioService.listar());
    }

    // =========================
    // LOGIN
    // =========================
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {

        try {

            Usuario u = usuarioService.login(
                    usuario.getEmail(),
                    usuario.getPassword()
            );

            return ResponseEntity.ok(u);

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // =========================
    // BUSCAR POR ID
    // =========================
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {

        try {

            return ResponseEntity.ok(usuarioService.buscarPorId(id));

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // =========================
    // ACTUALIZAR USUARIO
    // =========================
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(
            @PathVariable Long id,
            @RequestBody Usuario usuario
    ) {

        try {

            return ResponseEntity.ok(
                    usuarioService.actualizar(id, usuario)
            );

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // =========================
    // INACTIVAR USUARIO
    // =========================
    @PutMapping("/inactivar/{id}")
    public ResponseEntity<?> inactivar(@PathVariable Long id) {

        try {

            return ResponseEntity.ok(
                    usuarioService.inactivar(id)
            );

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // =========================
    // ELIMINAR USUARIO
    // =========================
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        try {

            usuarioService.eliminar(id);

            return ResponseEntity.ok(
                    "Usuario eliminado correctamente"
            );

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // =========================
    // USUARIOS ACTIVOS
    // =========================
    @GetMapping("/activos")
    public ResponseEntity<List<Usuario>> usuariosActivos() {

        return ResponseEntity.ok(
                usuarioService.usuariosActivos()
        );
    }

    // =========================
    // BUSCAR POR NOMBRE
    // =========================
    @GetMapping("/buscar/{nombre}")
    public ResponseEntity<List<Usuario>> buscarPorNombre(
            @PathVariable String nombre
    ) {

        return ResponseEntity.ok(
                usuarioService.buscarPorNombre(nombre)
        );
    }
}
