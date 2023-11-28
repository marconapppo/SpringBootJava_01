package com.example.SpringBootJava_01.Controller;

import com.example.SpringBootJava_01.Domain.Curso;
import com.example.SpringBootJava_01.Domain.Topico;
import com.example.SpringBootJava_01.JpaRepository.CursoRepository;

public class TopicoForm
{
    public String titulo;
    public String mensagem;
    public String nomeCurso;

    public Topico converter(CursoRepository cursoRepository)
    {
        Curso curso = cursoRepository.findByNome(nomeCurso);
        return new Topico(this.titulo, this.mensagem, curso);
    }

}
