package com.example.SpringBootJava_01.JpaRepository;

import com.example.SpringBootJava_01.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>
{
    Optional<Usuario> findByEmail (String email);
}
