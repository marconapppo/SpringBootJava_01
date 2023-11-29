package com.example.SpringBootJava_01.Controller;

import com.example.SpringBootJava_01.Domain.Curso;
import com.example.SpringBootJava_01.Domain.Topico;
import com.example.SpringBootJava_01.JpaRepository.CursoRepository;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class TopicoForm
{
    @NotNull @NotEmpty @Length(min = 5)
    public String titulo;
    @NotNull @NotEmpty @Length(min = 5)
    public String mensagem;
    @NotNull @NotEmpty
    public String nomeCurso;

    public Topico converter(CursoRepository cursoRepository)
    {
        Curso curso = cursoRepository.findByNome(nomeCurso);
        return new Topico(this.titulo, this.mensagem, curso);
    }

}
