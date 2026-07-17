package com.componentes.dani.proyecto.usuario.repository;

import com.componentes.dani.proyecto.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreoAndConstrasenna(String correo, String constrasenna);
}