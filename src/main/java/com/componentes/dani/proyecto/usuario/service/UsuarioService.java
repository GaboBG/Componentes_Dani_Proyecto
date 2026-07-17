package com.componentes.dani.proyecto.usuario.service;
import com.componentes.dani.proyecto.usuario.model.Usuario;
import com.componentes.dani.proyecto.usuario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setNombre(usuarioActualizado.getNombre());
                    usuario.setCorreo(usuarioActualizado.getCorreo());
                    usuario.setTelefono(usuarioActualizado.getTelefono());
                    usuario.setConstrasenna(usuarioActualizado.getConstrasenna());
                    return usuarioRepository.save(usuario);
                })
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
    public Usuario login(String correo, String constrasenna) {
        return usuarioRepository
                .findByCorreoAndConstrasenna(correo, constrasenna)
                .orElseThrow(() -> new RuntimeException("Credenciales inválidas"));
    }
}

