package com.back.pid_grupo01.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.pid_grupo01.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	  // Buscar un usuario por email
    Optional<Usuario> findByEmail(String email);

    // Buscar un usuario por dni
    Optional<Usuario> findByDni(String dni);

    // Buscar un usuario por username
    Optional<Usuario> findByNombre(String nombre);
}
