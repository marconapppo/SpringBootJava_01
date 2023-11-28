package com.example.SpringBootJava_01.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SpringBootJava_01.Domain.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>
{
    Curso findByNome(String nomeCurso);
}